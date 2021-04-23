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

//     static void parentPathElementsToString(Map<UUID, UUID> parentPathElements, Network net){
//         for (Map.Entry<UUID, UUID> el: parentPathElements.entrySet()) {
//             logger.debug("Parent of {} is {}", net.getPathElements().get(el.getKey()), net.getPathElements().get(el.getValue()));
//         }
//     }


    /** найти маршрут между элементами сети
     * по их id
     * */
    default List<PathElement> getRoute(UUID firstID, UUID secondID, Network net)
            throws RouteNotFoundException{

        Objects.requireNonNull(net, "Null net obj");

        WeightFunction<PathElement, Cable, Double> weightFunction = getWeightFunction();

        logger.debug("Start of generating the adjacency list");

        Map<UUID, List<Pair<UUID, Double>>> adjList = new HashMap<>();

        net.getCabelsSet().removeIf(cable -> cable.getConnections().size() != 2);
        //заполнение ключей
        for (UUID elemId: net.getPathElements().keySet()) {
            adjList.put(elemId, new ArrayList<Pair<UUID, Double>>());
        }
        //заполнение списков смежных вершин, соответствующих ключам
        for (Cable cable: net.getCabelsSet()) {
            PathElement first = cable.getConnections().get(0);
            PathElement second = cable.getConnections().get(1);

            Double weight = weightFunction.apply(first, cable);

            Pair<UUID, Double> pairSecondWeight = new Pair<UUID, Double>(second.getID(), weight);
            if (!findEdge(adjList, pairSecondWeight)) {
                adjList.get(first.getID()).add(pairSecondWeight);
            }

            logger.debug("To vertex {} added edge {} {}",  first.toString() , second.toString() , weight);

            weight = weightFunction.apply(second, cable);

            Pair<UUID, Double> pairFirstWeight = new Pair<UUID, Double>(first.getID(), weight);
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

        //записываем вершины в массив так, чтобы стартовая была на 0-ом месте
        UUID [] vertMas = new UUID[adjList.size()];
        vertMas[0] = firstID;
        int k  = 1;
        for (UUID key: adjList.keySet()) {
            if (key != firstID) {
                vertMas[k] = key;
                k++;
            }
        }

        //массив миним-х расстояний от стартовой вершины до друших вершин
        Map<UUID, Double> distance = new HashMap<>();
        distance.put(firstID, 0.0);
        for (UUID key: adjList.keySet()) {
            if (key != firstID) distance.put(key, Double.MAX_VALUE);
        }
        logger.debug("Start distance: {}", distance.values());

        Map<UUID, UUID> parentPathElement = new HashMap<>();
        for (UUID id: adjList.keySet()) {
            parentPathElement.put(id, null);
        }

        int n = adjList.size() - 1; //максимально возможное кол-во итераций
        while(n != 0){
            boolean stop = true;
            for(int i = 0; i < adjList.size(); i++){
                UUID vert = vertMas[i]; //текущая вершина
                PathElement el = netPathElements.get(vert);
                for (Pair<UUID, Double> pair: adjList.get(vert)) {
                    Double vertDist = distance.get(vert); //расстояние от стартовой вершины до текущей
                    Double nextVertDist = distance.get(pair.getFirst());
                    PathElement nextVert = netPathElements.get(pair.getFirst());
                    if (vertDist + pair.getSecond() < nextVertDist && vertDist != Double.MAX_VALUE){
                        distance.put(pair.getFirst(), vertDist + (Double)pair.getSecond());
                        parentPathElement.put(nextVert.getID(), el.getID());
                        stop = false;
                        distanceToString(el, distance);
                    }
                }
            }
            n--;
            if (!stop) {break;}
        }

//        for (Map.Entry<UUID, Double> el: distance.entrySet()) {
//            Double elemTimeDelay = netPathElements.get(el.getKey()).getTimeDelay();
//            distance.put(el.getKey(), el.getValue() + elemTimeDelay);
//        }
//        logger.debug("Final distance: {}", distance.values());

        List<PathElement> pathList = new ArrayList<>();
        if (distance.get(secondID) == Double.MAX_VALUE)
            throw new RouteNotFoundException("There is no path between given vertices");
        else{

            UUID pathElementUUID = secondID;
            while(parentPathElement.get(pathElementUUID) != null){
                pathList.add(netPathElements.get(pathElementUUID));
                pathElementUUID = parentPathElement.get(pathElementUUID);
            }
            pathList.add(netPathElements.get(firstID));
        }

        List<PathElement> reversPathList = new ArrayList<>();
        for(int i = pathList.size() - 1; i >= 0; i--){
            reversPathList.add(pathList.get(i));
        }



        logger.debug("Algorithm ended");
        logger.debug("Total weight of path between given elements is {} ", distance.get(secondID));
        logger.debug("Result path: {}", reversPathList);
        return reversPathList;







        //return List<PathElement> or throws RouteNotFoundException
    }
    //по их IpAddress
//    static List<PathElement> getRoute(InetAddress firstID, InetAddress secondID, Network net){
//        return List<PathElement> or throws RouteNotFoundException
//    }


    //описание
    public static String getDescription(){
        return "Use RouteProvider.getRoute(Integer firstID, Integer secondID, Network net) \n" +
                "to find the route between path elements of network \n";
    }
}

