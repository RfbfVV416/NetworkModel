package albe.model;
import java.util.List;
import java.util.UUID;

public class PassiveElement implements PathElement{
    protected Double timeDelay;
    protected Double costs;
    protected List<PathElement> connections;
    protected UUID id;

    PassiveElement(Double timeDelay, Double costs, UUID id, List<PathElement> connections){
        this.timeDelay = timeDelay;
        this.costs = costs;
        this.id = id;
        this.connections = connections;
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
    public List<PathElement> getConnections(){
        return connections;
    }

    public void addConnection(PathElement pathElement){
        if (pathElement == null) throw new IllegalArgumentException();
        else if (!connections.contains(pathElement)){
            connections.add(pathElement);
            pathElement.addConnection(this);
        }
    }

    public void removeConnection (PathElement pathElement){
        if (connections.contains(pathElement)){
            connections.remove(pathElement);
            pathElement.removeConnection(this);
        }
    }

}
