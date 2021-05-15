package NetworkModel;

import com.fasterxml.jackson.annotation.JsonTypeName;

import java.util.UUID;
@JsonTypeName("pc")
public class PC extends ActiveElement{
    public PC(){}

    public PC(Double timeDelay, Double costs, UUID id, String ipAddress){
        super(timeDelay, costs, id, ipAddress);
    }

    @Override
    public String toString() {
        return "PC{" +
                "ipAddress='" + ipAddress + '\'' +
                '}';
    }
}
