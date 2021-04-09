package albe.model;

import java.net.InetAddress;

public interface RouteProvider{
    //найти маршрут между элементами сети
    //по их id
//    public static List<PathElement> getRoute(Integer firstID, Integer secondID, Network net){
//    return List<PathElement> or throws RouteNotFoundException
//    }
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
