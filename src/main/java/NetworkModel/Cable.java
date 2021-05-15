package NetworkModel;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.List;
@JsonAutoDetect
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property="type")
@JsonSubTypes({
        @JsonSubTypes.Type(value=CoaxialCable.class, name="coaxialCable"),
        @JsonSubTypes.Type(value=StpCable.class, name="STPCable"),
        @JsonSubTypes.Type(value=UtpCable.class, name="UTPCable")
})
public interface Cable{
    public Double getTimeDelay();
    public Double getCosts();
    public List<PathElement> getConnections();
    public  String getInfo();

//    @JsonValue
//    public default String toJsonValue(){
//        return toString();
//    }

}
