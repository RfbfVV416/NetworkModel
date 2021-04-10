package albe.model;
import java.net.InetAddress;
import java.util.UUID;
import java.util.List;

public class PC extends ActiveElement{
    public PC(Double timeDelay, Double costs, UUID id, List<Cable> connections, InetAddress ipAddress){

        super(timeDelay, costs, id, connections, ipAddress);
    }

}
