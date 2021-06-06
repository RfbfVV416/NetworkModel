package NetworkModel;

public class RouteProviderTimeDelay implements  RouteProvider{
    public final WeightFunction<PathElement, Cable, Double>
    getWeightFunction(){
        return (
                (pathElement, cable) -> cable == null ?
                        pathElement.getTimeDelay() : pathElement.getTimeDelay() + cable.getTimeDelay()
        );
    }
}
