package NetworkModel;

import com.fasterxml.jackson.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property="type")
@JsonSubTypes({
          @JsonSubTypes.Type(value=Router.class, name="router"),
        @JsonSubTypes.Type(value=Firewall.class, name="firewall"),
        @JsonSubTypes.Type(value=PC.class, name="pc"),
        @JsonSubTypes.Type(value=Switch.class, name="switch")
})
public class ActiveElement implements PathElement{
    protected Double timeDelay;
    protected Double costs;
    protected UUID id;
    protected List<Cable> connections;
    protected String ipAddress;

    public ActiveElement(){}

    public ActiveElement(Double timeDelay, Double costs, UUID id, String ipAddress){
        this.timeDelay = timeDelay;
        this.costs = costs;
        this.id = id;
        connections = new ArrayList<>();
        this.ipAddress = ipAddress;
    }

    public Double getTimeDelay(){
        return timeDelay;
    }
    public Double getCosts(){
        return costs;
    }
    public String getInfo(){ return "This is an active element"; }
    public UUID getID(){ return id; }
    public List<Cable> getConnections(){
        return connections;
    }
    public String getIpAddress(){
        return ipAddress;
    }


    public void addConnection(Cable cable){
        if (connections.size() == 2) connections.clear();
        connections.removeIf((cable1)->{
            return cable1.getConnections().equals(cable.getConnections());
        });
        connections.add(cable);
    }

    @Override
    public String toString() {
        return "ActiveElement{" +
                "ipAddress='" + ipAddress + '\'' +
                '}';
    }
}
