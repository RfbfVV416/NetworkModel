package albe.model;
import java.util.UUID;
import java.util.List;

public class Switch extends ActiveElement{
    public Switch(Double timeDelay, Double costs, UUID id, List<PathElement> connections, List<IPAddress> ipAddress){
        super(timeDelay, costs, id, connections, ipAddress);
    }

}
