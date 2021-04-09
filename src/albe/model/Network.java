package albe.model;
import java.util.*;
import java.util.UUID;

public class Network implements RouteProvider{
    private Map<UUID, PathElement> pathElementMap;
    public Network(){
        pathElementMap = new HashMap<UUID,PathElement>();
    }
    //получить все элементы данной сети с их id (<id экземпляра класса, этот экземпляр>)
    public Map<UUID, PathElement> getPathElements(){
        return pathElementMap;
    }

    public void add(UUID id, PathElement pathElement){
        if (pathElement == null || id == null) throw new IllegalArgumentException();
        else pathElementMap.put(id, pathElement);
    }

    public void remove(UUID id){
        if (!pathElementMap.containsKey(id)) throw new IllegalArgumentException();
        else {
            PathElement elementValue = pathElementMap.get(id);
            for (PathElement elem: pathElementMap.values()) {
                if (elem.getConnections().contains(elementValue)) elem.removeConnection(elementValue);
            }
            pathElementMap.remove(id);
        }
    }
}
