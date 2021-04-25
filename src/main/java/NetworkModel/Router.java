package NetworkModel;

import java.util.UUID;

public class Router extends  ActiveElement{
    public Router(Double timeDelay, Double costs, UUID id, String ipAddress){
        super(timeDelay, costs, id, ipAddress);
    }

}
