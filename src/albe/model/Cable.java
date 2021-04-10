package albe.model;

import java.util.List;

public interface Cable{
    public Double getTimeDelay();
    public Double getCosts();
    public List<PathElement> getConnections();
    public String getInfo();
    public void addConnection(PathElement pathElement);
    public void removeConnection (PathElement pathElement);
}
