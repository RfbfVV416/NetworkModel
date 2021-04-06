package albe.model;
import java.util.*;
import java.util.UUID;
public interface PathElement{

    public Double getTimeDelay();
    public Double getCosts();
    public List<PathElement> getConnections();
    public String getInfo();
    public String getID();
    public void addConnection(PathElement pathElement);
    public void removeConnection(PathElement pathElement);
    public static UUID generateID(){ return UUID.randomUUID(); }

}
