package NetworkModel;

import java.util.List;

public interface Cable{
    public Double getTimeDelay();
    public Double getCosts();
    public List<PathElement> getConnections();
    public String getInfo();

}
