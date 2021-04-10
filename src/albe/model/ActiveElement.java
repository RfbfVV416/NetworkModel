package albe.model;
import java.lang.instrument.IllegalClassFormatException;
import java.net.InetAddress;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import albe.model.Cable;


public class ActiveElement implements PathElement{
    protected Double timeDelay;
    protected Double costs;
    protected UUID id;
    protected List<Cable> connections;
    protected InetAddress ipAddress;

    public ActiveElement(Double timeDelay, Double costs, UUID id, List<Cable> connections, InetAddress ipAddress){
        this.timeDelay = timeDelay;
        this.costs = costs;
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
    public List<Cable> getConnections(){
        return connections;
    }
    public InetAddress getIP(){
        return ipAddress;
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
