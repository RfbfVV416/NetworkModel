package albe.model;
import java.util.List;
import java.util.UUID;

public class PassiveElement implements PathElement{
    protected Double timeDelay;
    protected Double costs;
    protected List<Cable> connections;
    protected UUID id;

    public PassiveElement(Double timeDelay, Double costs, UUID id, List<Cable> connections){
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
    public List<Cable> getConnections(){
        return connections;
    }

    public void addConnection(Cable cable){
        if (cable == null) throw new IllegalArgumentException();
        else {
            if (!connections.contains(cable)){
                connections.add(cable);
                //if (!cable.getConnections().contains(this))
                    cable.addConnection(this);
            }
        }
    }

    public void removeConnection (Cable cable){
        if (connections.contains(cable)){
            connections.remove(cable);
            cable.removeConnection(this);
        }
    }

}
