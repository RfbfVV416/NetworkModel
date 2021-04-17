package NetworkModel;

import java.util.*;
import org.slf4j.*;
import org.slf4j.LoggerFactory;

public interface RouteProvider{
    final Logger logger = LoggerFactory.getLogger(RouteProvider.class);

    public static boolean findEdge(Map<UUID, List<Pair<UUID, Double>>> adjList, Pair<UUID, Double> pair){
        boolean fl = false;
        for (List<Pair<UUID, Double>> list: adjList.values()) {
            if(list.contains(pair)) fl = true;
        }
        return fl;
    }


    /** найти маршрут между элементами сети
     * по их id
     * */
    public static void getRoute(UUID firstID, UUID secondID, Network net){

        Map<UUID, List<Pair<UUID, Double>>> adjList = new HashMap<>();
        /**каждое ребро соединяет ровно 2 элемента*/
        net.getCabelsSet().removeIf(cable -> cable.getConnections().size() != 2);
        //заполнение ключей
        for (UUID elemId: net.getPathElements().keySet()) {
            adjList.put(elemId, new ArrayList<Pair<UUID, Double>>());
        }
        //заполнение списков смежных вершин, соответствующих ключам
        for (Cable cable: net.getCabelsSet()) {
            PathElement first = cable.getConnections().get(0);
            PathElement second = cable.getConnections().get(1);

            Double weight;
            if (net.getWeight().equals("costs")){
                weight = first.getCosts() + cable.getCosts() + second.getCosts();
            }
            else if (net.getWeight().equals("timeDelay")){
                weight = first.getTimeDelay() + cable.getTimeDelay() + second.getTimeDelay();
            }
            else{ throw new IllegalArgumentException(); }


            Pair<UUID, Double> pairSecondWeight = new Pair<UUID, Double>(second.getID(), weight);
            if (!findEdge(adjList, pairSecondWeight)) {
                adjList.get(first.getID()).add(pairSecondWeight);
            }


            logger.debug("To vertex " + first.toString() + "added edge " + second.toString() + " " + weight);
//            System.out.print(first);
//            System.out.print(" ");
//            System.out.print(second);
//            System.out.print(" ");
//            System.out.println(pairSecondWeight.getSecond());

            Pair<UUID, Double> pairFirstWeight = new Pair<UUID, Double>(first.getID(), weight);
            if (!findEdge(adjList, pairFirstWeight)) {
                adjList.get(second.getID()).add(pairFirstWeight);
            }

            logger.debug("To vertex " + second.toString() + "added edge " + first.toString() + " " + weight);
//            System.out.print(second);
//            System.out.print(" ");
//            System.out.print(first);
//            System.out.print(" ");
//            System.out.println(pairFirstWeight.getSecond());

        }

        System.out.print("adjList\n\n");
        for (List<Pair<UUID, Double>> list: adjList.values()) {
            System.out.print("el:\n");
            for (int i = 0; i < list.size(); i++){
                System.out.print("     ");
                System.out.print(net.getPathElements().get(list.get(i).getFirst()));
                System.out.print(" ");
                System.out.print(list.get(i).getSecond());
                System.out.print("\n");
            }
        }

        //записываем вершины в массив так, чтобы стартовая была на 0-ом месте
        UUID vertMas[] = new UUID[adjList.size()];
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


        int n = adjList.size() - 1; //максимально возможное кол-во итераций
        while(n != 0){
            boolean stop = true;
            for(int i = 0; i < adjList.size(); i++){
                UUID vert = vertMas[i]; //текущая вершина
                for (Pair<UUID, Double> pair: adjList.get(vert)) {
                    Double vertDist = distance.get(vert); //расстояние от стартовой вершины до текущей
                    Double nextVertDist = distance.get(pair.getFirst());
                    if (vertDist + pair.getSecond() > nextVertDist){ //&& vertDist != Double.MAX_VALUE
                        distance.put(pair.getFirst(), vertDist + (Double)pair.getSecond());
                        stop = false;
                    }
                }
            }
            n--;
            if (!stop) {break;}
        }

        System.out.print(distance.get(secondID));





        //return List<PathElement> or throws RouteNotFoundException
    }
    //по их IpAddress
//    public static List<PathElement> getRoute(InetAddress firstID, InetAddress secondID, Network net){
//        return List<PathElement> or throws RouteNotFoundException
//    }


    //описание
    public static String getDescription(){
        return "Use RouteProvider.getRoute(Integer firstID, Integer secondID, Network net) \n" +
                "to find the route between path elements of network \n";
    }
}

