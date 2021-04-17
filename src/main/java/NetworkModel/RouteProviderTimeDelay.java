package NetworkModel;

public class RouteProviderTimeDelay implements  RouteProvider{
    public final WeightFunction<PathElement, Cable, PathElement, Double> getWeightFunction(){
        return ((pathElement, cable, pathElement2) -> pathElement.getTimeDelay() + cable.getTimeDelay() + pathElement2.getTimeDelay());
    }
}
