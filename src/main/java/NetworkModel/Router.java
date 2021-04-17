package NetworkModel;

import java.net.InetAddress;
import java.util.UUID;

public class Router extends  ActiveElement{
    public Router(Double timeDelay, Double costs, UUID id, InetAddress ipAddress){
        super(timeDelay, costs, id, ipAddress);
    }

}
