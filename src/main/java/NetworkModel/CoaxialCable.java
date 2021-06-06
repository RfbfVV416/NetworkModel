package NetworkModel;
import com.fasterxml.jackson.annotation.*;
import java.util.ArrayList;
import java.util.List;

@JsonTypeName("coaxialCable")
public class CoaxialCable implements Cable {
    private Double timeDelay;
    private Double costs;
    @JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
    private List<PathElement> connections;

    public CoaxialCable(){}

    public CoaxialCable(Double timeDelay, Double costs, PathElement pathEl1, PathElement pathEl2){
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
    public String getInfo(){ return "Сoaxial cable"; }



    @Override
    public String toString() {
        return "CoaxialCable{\n" +
                "timeDelay=" + timeDelay + "\n" +
                ", costs=" + costs + "\n" +
                ", connections=" + connections + "\n" +
                "}\n";
    }
}

