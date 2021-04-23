package NetworkModel;

public class RouteProviderTimeDelay implements  RouteProvider{
    public final WeightFunction<PathElement, Cable, Double> getWeightFunction(){
        return ((pathElement, cable) -> pathElement.getTimeDelay() + cable.getTimeDelay());
    }
}
