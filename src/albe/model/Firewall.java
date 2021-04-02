package albe.model;

import java.util.ArrayList;

public class Firewall extends ActiveElement{
    public Firewall(Double timeDelay, Double costs, ArrayList<PathElement> connections, ArrayList<IPAddress> ipAddress){
        super(timeDelay, costs, connections, ipAddress);
    }

}
