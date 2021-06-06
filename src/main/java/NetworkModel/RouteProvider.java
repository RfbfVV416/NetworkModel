package NetworkModel;
import java.util.*;
import org.slf4j.*;
import org.slf4j.LoggerFactory;

public interface RouteProvider{
     Logger logger = LoggerFactory.getLogger(RouteProvider.class);

     static boolean findEdge(Map<UUID, List<Pair<UUID, Double>>> adjList, Pair<UUID, Double> pair){
        boolean fl = false;
        for (List<Pair<UUID, Double>> list: adjList.values()) {
            if(list.contains(pair)) fl = true;
        }
        return fl;
    }

    WeightFunction<PathElement, Cable, Double> getWeightFunction();

     static void distanceToString(PathElement el, Map<UUID, Double> distance){
             logger.debug("Current vertex {}: {} ", el, distance.values());
     }

    default List<PathElement> getRoute(UUID firstID, UUID secondID, Network net)
            throws RouteNotFoundException{

        Objects.requireNonNull(net, "Null net obj");

        WeightFunction<PathElement, Cable, Double> weightFunction
                = getWeightFunction();

        logger.debug("Start of generating the adjacency list");

        Map<UUID, List<Pair<UUID, Double>>> adjList = new HashMap<>();
        net.getCablesSet().removeIf(cable -> cable.getConnections().size() != 2);

        for (UUID elemId: net.getPathElements().keySet()) {
            adjList.put(elemId, new ArrayList<Pair<UUID, Double>>());
        }

        for (Cable cable: net.getCablesSet()) {
            PathElement first = cable.getConnections().get(0);
            PathElement second = cable.getConnections().get(1);

            Double weight = weightFunction.apply(first, cable);

            Pair<UUID, Double> pairSecondWeight = new Pair<>(second.getID(), weight);
            if (!findEdge(adjList, pairSecondWeight)) {
                adjList.get(first.getID()).add(pairSecondWeight);
            }

            logger.debug("To vertex {} added edge {} {}",  first.toString() , second.toString() , weight);

            weight = weightFunction.apply(second, cable);

            Pair<UUID, Double> pairFirstWeight = new Pair<>(first.getID(), weight);
            if (!findEdge(adjList, pairFirstWeight)) {
                adjList.get(second.getID()).add(pairFirstWeight);
            }

            logger.debug("To vertex {} added edge {} {}",  second.toString() , first.toString() , weight);

        }

        logger.debug("Generated adjacency list: ");
        for (Map.Entry<UUID, List<Pair<UUID, Double>>> el: adjList.entrySet()) {
            logger.debug("el {} : ", net.getPathElements().get(el.getKey()));
            for (Pair<UUID, Double> pair: el.getValue()) {
                logger.debug("         {} {} ", net.getPathElements().get(pair.getFirst()), pair.getSecond());
            }
        }

        logger.debug("Algorithm started ");

        Map<UUID, PathElement> netPathElements = net.getPathElements();

        UUID [] vertMas = new UUID[adjList.size()];
        vertMas[0] = firstID;
        int k  = 1;
        for (UUID key: adjList.keySet()) {
            if (!firstID.equals(key)) {
                vertMas[k] = key;
                k++;
            }
        }

        Map<UUID, Double> distance = new HashMap<>();
        distance.put(firstID, 0.0);
        for (UUID key: adjList.keySet()) {
            if (!firstID.equals(key)) distance.put(
                    key, Double.MAX_VALUE
            );
        }
        logger.debug("Start distance: {}", distance.values());

        Map<UUID, UUID> parentPathElement = new HashMap<>();
        for (UUID id: adjList.keySet()) {
            parentPathElement.put(id, null);
        }

        int n = adjList.size() - 1;
        while(n != 0){
            for(int i = 0; i < adjList.size(); i++){
                UUID vert = vertMas[i];
                PathElement el = netPathElements.get(vert);
                for (Pair<UUID, Double> pair: adjList.get(vert)) {
                    Double vertDist = distance.get(vert);
                    Double nextVertDist = distance.get(
                            pair.getFirst()
                    );
                    PathElement nextVert = netPathElements.get(pair.getFirst());
                    if (vertDist + pair.getSecond()
                               < nextVertDist
                               && vertDist
                               != Double.MAX_VALUE){
                        distance.put(
                                pair.getFirst(), vertDist + (Double)pair.getSecond()
                        );
                        parentPathElement.put(
                                nextVert.getID(), el.getID()
                        );
                        distanceToString(el, distance);
                    }
                }
            }
            n--;
        }

        Double lastVertWeight = weightFunction.apply(netPathElements.get(secondID), null);
        distance.put(secondID, distance.get(secondID) + lastVertWeight);

        List<PathElement> pathList = new ArrayList<>();
        if (distance.get(secondID) == Double.MAX_VALUE)
            throw new RouteNotFoundException("There is no path between given vertices");
        else{

            UUID pathElementUUID = secondID;
            while(parentPathElement.get(pathElementUUID) != null){
                pathList.add(
                        netPathElements.get(pathElementUUID)
                );
                pathElementUUID = parentPathElement.get(
                        pathElementUUID
                );
            }
            pathList.add(netPathElements.get(firstID));
        }

        List<PathElement> reversPathList =
                new ArrayList<>();
        for(int i = pathList.size() - 1; i >= 0; i--){
            reversPathList.add(pathList.get(i));
        }

        logger.debug("Algorithm ended");
        logger.debug("Total weight of path between given elements is {} ", distance.get(secondID));
        logger.debug("Result path: {}", reversPathList);
        return reversPathList;
    }

    default List<PathElement> getRoute(String firstIP, String secondIP, Network net) throws RouteNotFoundException {
        UUID firstID = net.getIpAddressUUIDMap().get(firstIP);
        UUID secondID = net.getIpAddressUUIDMap().get(secondIP);
        return getRoute(firstID, secondID, net);
    }

    public static String getDescription(){
        return "Use RouteProvider.getRoute(Integer firstID, Integer secondID, Network net) \n" +
                "to find the route between path elements of network \n";
    }
}



