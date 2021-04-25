package NetworkModel;

import com.google.common.net.InetAddresses;

import java.util.*;
import java.util.UUID;

public interface PathElement{

    public Double getTimeDelay();
    public Double getCosts();
    public List<Cable> getConnections();
    public String getInfo();


    public void addConnection(Cable cable);
    public UUID getID();
    public static UUID generateID(){ return UUID.randomUUID(); }
    public static String generateIP(){
        Random random = new Random();
        return InetAddresses.fromInteger(random.nextInt()).getHostAddress();
    }

}
