package albe.model;

import java.util.ArrayList;

public class PC extends ActiveElement{
    public PC(Double timeDelay, Double costs, ArrayList<PathElement> connections, ArrayList<IPAddress> ipAddress){

        super(timeDelay, costs, connections, ipAddress);
    }

}
