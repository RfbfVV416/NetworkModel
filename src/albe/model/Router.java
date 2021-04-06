package albe.model;
import java.util.UUID;
import java.util.List;

public class Router extends  ActiveElement{
    public Router(Double timeDelay, Double costs, UUID id, List<PathElement> connections, List<IPAddress> ipAddress){
        super(timeDelay, costs, id, connections, ipAddress);
    }

}
