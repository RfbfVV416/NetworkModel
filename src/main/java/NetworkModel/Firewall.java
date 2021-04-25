package NetworkModel;

import java.util.UUID;

public class Firewall extends ActiveElement{
    public Firewall(Double timeDelay, Double costs, UUID id, String ipAddress){
        super(timeDelay, costs, id, ipAddress);
    }

}
