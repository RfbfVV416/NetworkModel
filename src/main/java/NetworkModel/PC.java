package NetworkModel;

import java.net.InetAddress;
import java.util.UUID;

public class PC extends ActiveElement{
    public PC(Double timeDelay, Double costs, UUID id, InetAddress ipAddress){

        super(timeDelay, costs, id, ipAddress);
    }

}
