package albe.model;

import java.util.ArrayList;

public class Router extends  ActiveElement{
    public Router(Double timeDelay, Double costs, ArrayList<PathElement> connections, ArrayList<IPAddress> ipAddress){
        super(timeDelay, costs, connections, ipAddress);
    }

}
