package NetworkModel;

public class RouteProviderCosts implements RouteProvider{
    public final WeightFunction<PathElement, Cable, PathElement, Double> getWeightFunction(){
        return ((pathElement, cable, pathElement2) -> pathElement.getCosts() + cable.getCosts() + pathElement2.getCosts());
    }
}
