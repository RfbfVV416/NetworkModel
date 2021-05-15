package NetworkModel;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.google.common.net.InetAddresses;

import java.util.*;
import java.util.UUID;
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property="type")
@JsonSubTypes({
        @JsonSubTypes.Type(value=ActiveElement.class, name="activeElement"),
        @JsonSubTypes.Type(value=PassiveElement.class, name="passiveElement")
})
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
