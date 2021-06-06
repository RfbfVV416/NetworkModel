package NetworkModel;

public class RouteProviderCosts implements RouteProvider{
    public final WeightFunction<PathElement, Cable, Double> getWeightFunction(){
        return (
                (pathElement, cable) -> cable == null ?
                        pathElement.getCosts() : pathElement.getCosts() + cable.getCosts()
        );
    }

}
