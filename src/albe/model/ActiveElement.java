package albe.model;
import java.util.List;
import java.util.UUID;

public class ActiveElement implements PathElement{
    protected Double timeDelay;
    protected Double costs;
    protected UUID id;
    protected List<PathElement> connections;
    protected List<IPAddress> ipAddress;

    ActiveElement(Double timeDelay, Double costs, UUID id, List<PathElement> connections, List<IPAddress> ipAddress){
        this.timeDelay = timeDelay;
        this.costs = costs;
        //this.id = UUID.randomUUID();
        this.id = id;
        this.connections = connections;
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

    public List<PathElement> getConnections(){
        return connections;
    }

    public List<IPAddress> getIP(){
        return this.ipAddress;
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
