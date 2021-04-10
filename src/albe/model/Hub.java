package albe.model;
import java.util.UUID;
import java.util.List;

public class Hub extends PassiveElement{
    public Hub(Double timeDelay, Double costs, UUID id, List<Cable> connections){

        super(timeDelay, costs, id, connections);
    }

}
