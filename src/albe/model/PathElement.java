package albe.model;
import albe.model.Cable;
import java.util.*;
import java.util.UUID;
public interface PathElement{

    public Double getTimeDelay();
    public Double getCosts();
    public List<Cable> getConnections();
    public String getInfo();


    public void addConnection(Cable cable);
    public void removeConnection(Cable cable);
    public UUID getID();
    public static UUID generateID(){ return UUID.randomUUID(); }
}
