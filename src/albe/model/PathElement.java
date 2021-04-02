package albe.model;
import java.util.*;

public interface PathElement{

    public Double getTimeDelay();
    public Double getCosts();
    public ArrayList<PathElement> getConnections();
    public String getInfo();
    public String getID();
    public void addConnection(PathElement pathElement);
    public void removeConnection(PathElement pathElement);

}
