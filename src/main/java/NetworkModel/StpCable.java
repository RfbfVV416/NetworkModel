package NetworkModel;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.ArrayList;
import java.util.List;

public class StpCable implements Cable{
    private Double timeDelay;
    private Double costs;
    private List<PathElement> connections;

    public StpCable(Double timeDelay, Double costs, PathElement pathEl1, PathElement pathEl2){
        this.timeDelay = timeDelay;
        this.costs = costs;
        connections = new ArrayList<PathElement>();
        connections.add(pathEl1);
        connections.add(pathEl2);
        pathEl1.addConnection(this);
        pathEl2.addConnection(this);
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
        return "STP cable";
    }


    @Override
    public String toString() {
        return "StpCable{" +
                "timeDelay=" + timeDelay +
                ", costs=" + costs +
                ", connections=" + connections +
                '}';
    }
}
