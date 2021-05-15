package NetworkModel;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property="type")
@JsonSubTypes({
        @JsonSubTypes.Type(value=Hub.class, name="hub")
})
public class PassiveElement implements PathElement{
    protected Double timeDelay;
    protected Double costs;
    protected List<Cable> connections;
    protected UUID id;

    public PassiveElement(){}

    public PassiveElement(Double timeDelay, Double costs, UUID id){
        this.timeDelay = timeDelay;
        this.costs = costs;
        this.id = id;
        connections = new ArrayList<Cable>();
    }

    public Double getTimeDelay(){
        return timeDelay;
    }
    public Double getCosts(){
        return costs;
    }
    public String getInfo(){
        return "This is a passive element";
    }
    public UUID getID(){ return id; }
    public List<Cable> getConnections(){
        return connections;
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

    @Override
    public String toString() {
        return "PassiveElement{" +
                "id=" + id +
                '}';
    }



}
