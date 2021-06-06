package NetworkModel;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.UUID;

@JsonTypeName("hub")
public class Hub extends PassiveElement{
    public Hub(){}
    public Hub(Double timeDelay, Double costs, UUID id){
        super(timeDelay, costs, id);
    }

    @Override
    public String toString() {
        return "Hub{" +
                "id=" + id +
                '}';
    }
}
