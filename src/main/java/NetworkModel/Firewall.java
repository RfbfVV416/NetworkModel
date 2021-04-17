package NetworkModel;

import java.net.InetAddress;
import java.util.UUID;

public class Firewall extends ActiveElement{
    public Firewall(Double timeDelay, Double costs, UUID id, InetAddress ipAddress){
        super(timeDelay, costs, id, ipAddress);
    }

}
