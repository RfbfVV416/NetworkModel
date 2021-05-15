package NetworkModel;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    Double getTimeDelay();
    Double getCosts();
    List<Cable> getConnections();
    @JsonIgnore
    String getInfo();


    void addConnection(Cable cable);
    UUID getID();
    static UUID generateID(){ return UUID.randomUUID(); }
    static String generateIP(){
        Random random = new Random();
        return InetAddresses.fromInteger(random.nextInt()).getHostAddress();
    }

}
