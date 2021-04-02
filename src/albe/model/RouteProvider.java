package albe.model;

public interface RouteProvider{
    //найти маршрут между элементами сети
    //public static List<PathElement> getRoute(Integer firstID, Integer secondID, Network net){
    //return List<PathElement> or throws RouteNotFoundException
    //}
    //описание
    public static String getDescription(){
        return "Use RouteProvider.getRoute(Integer firstID, Integer secondID, Network net) \n" +
                "to find the route between path elements of network \n";
    }
}
