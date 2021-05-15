package NetworkModel;

import com.fasterxml.jackson.annotation.*;

import java.util.List;
@JsonAutoDetect
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property="type")
@JsonSubTypes({
        @JsonSubTypes.Type(value=CoaxialCable.class, name="coaxialCable"),
        @JsonSubTypes.Type(value=StpCable.class, name="STPCable"),
        @JsonSubTypes.Type(value=UtpCable.class, name="UTPCable")
})
public interface Cable{
    Double getTimeDelay();
    Double getCosts();
    List<PathElement> getConnections();
    @JsonIgnore
    String getInfo();

}
