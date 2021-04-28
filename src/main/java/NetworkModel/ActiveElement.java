package NetworkModel;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class ActiveElement implements PathElement{
    protected Double timeDelay;
    protected Double costs;
    protected UUID id;
    protected List<Cable> connections;
    protected String ipAddress;

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
    public String getInfo(){
        return "This is an active element";
    }
    public UUID getID(){ return id; }
    public List<Cable> getConnections(){
        return connections;
    }
    public String getIP(){
        return ipAddress;
    }


    public void addConnection(Cable cable){
        if (connections.size() == 2) connections.clear();
        connections.removeIf((cable1)->{
            return cable1.getConnections().equals(cable.getConnections());
        });
        connections.add(cable);
    }

    @JsonValue
    public  String toJsonValue(){
        return toString();
    }
}
