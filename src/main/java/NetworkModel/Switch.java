package NetworkModel;

import com.fasterxml.jackson.annotation.JsonTypeName;

import java.util.UUID;
@JsonTypeName("switch")
public class Switch extends ActiveElement{
    public Switch(Double timeDelay, Double costs, UUID id, String ipAddress){

        super(timeDelay, costs, id, ipAddress);
    }

    @Override
    public String toString() {
        return "Switch{" +
                "ipAddress='" + ipAddress + '\'' +
                '}';
    }

}
