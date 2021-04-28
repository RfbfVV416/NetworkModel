package NetworkModel;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.List;
@JsonAutoDetect
public interface Cable{
    public Double getTimeDelay();
    public Double getCosts();
    public List<PathElement> getConnections();
    public String getInfo();
//    @JsonValue
//    public default String toJsonValue(){
//        return toString();
//    }

}
