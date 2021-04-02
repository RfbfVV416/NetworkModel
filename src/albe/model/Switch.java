package albe.model;

import java.util.ArrayList;

public class Switch extends ActiveElement{
    public Switch(Double timeDelay, Double costs, ArrayList<PathElement> connections, ArrayList<IPAddress> ipAddress){
        super(timeDelay, costs, connections, ipAddress);
    }

}
