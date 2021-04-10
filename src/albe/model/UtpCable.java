package albe.model;

import java.util.List;

public class UtpCable implements Cable{
    private Double timeDelay;
    private Double costs;
    private List<PathElement> connections;

    public UtpCable(Double timeDelay, Double costs, List<PathElement> connections){
        this.timeDelay = timeDelay;
        this.costs = costs;
        this.connections = connections;
    }

    public List<PathElement> getConnections(){
        return connections;
    }
    public Double getTimeDelay(){
        return timeDelay;
    }
    public Double getCosts(){
        return costs;
    }
    public String getInfo(){
        return "UTP cable";
    }

    public void addConnection(PathElement pathElement){
        if (pathElement == null) throw new IllegalArgumentException();
        else if (connections.size() == 2) throw new IndexOutOfBoundsException();
        else {
            if (!connections.contains(pathElement)){
                connections.add(pathElement);
                //if (!pathElement.getConnections().contains(this))
                pathElement.addConnection(this);
            }
        }
    }

    public void removeConnection (PathElement pathElement){
        if (connections.contains(pathElement)){
            connections.remove(pathElement);
            pathElement.removeConnection(this);
        }
    }

}
