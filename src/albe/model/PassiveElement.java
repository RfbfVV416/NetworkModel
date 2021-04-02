package albe.model;
import java.util.ArrayList;
import java.util.UUID;

public class PassiveElement implements PathElement{
    protected Double timeDelay;
    protected Double costs;
    protected ArrayList<PathElement> connections;
    protected UUID id;

    PassiveElement(Double timeDelay, Double costs, ArrayList<PathElement> connections){
        this.timeDelay = timeDelay;
        this.costs = costs;
        this.connections = connections;
        this.id = UUID.randomUUID();
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
    public String getID(){
        return id.toString();
    }
    public ArrayList<PathElement> getConnections(){
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
