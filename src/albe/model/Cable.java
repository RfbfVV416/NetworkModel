package albe.model;
import java.util.List;
import java.util.UUID;

public class Cable extends PassiveElement{
    public Cable(Double timeDelay, Double costs, UUID id, List<PathElement> connections){
        super(timeDelay, costs, id, connections);
    }

}
