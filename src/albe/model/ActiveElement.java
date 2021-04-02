package albe.model;
import java.util.*;

public class ActiveElement implements PathElement{
    protected Double timeDelay;
    protected Double costs;
    protected UUID id;
    protected ArrayList<PathElement> connections;
    protected ArrayList<IPAddress> ipAddress;

    ActiveElement(Double timeDelay, Double costs, ArrayList<PathElement> connections, ArrayList<IPAddress> ipAddress){
        this.timeDelay = timeDelay;
        this.costs = costs;
        this.id = UUID.randomUUID();
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
    public String getID(){
        return id.toString();
    }

    public ArrayList<PathElement> getConnections(){
        return connections;
    }

    public ArrayList<IPAddress> getIP(){
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
