package NetworkModel;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.UUID;

@JsonTypeName("firewall")
public class Firewall extends ActiveElement{

    public Firewall(){}

    public Firewall(Double timeDelay, Double costs, UUID id, String ipAddress){
        super(timeDelay, costs, id, ipAddress);
    }

    @Override
    public String toString() {
        return "Firewall{" +
                "ipAddress='" + ipAddress + '\'' +
                '}';
    }
}
