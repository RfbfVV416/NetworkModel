package albe.model;
import java.util.*;
import java.util.UUID;
import java.net.InetAddress;

public class Network implements RouteProvider{
    private Map<UUID, PathElement> pathElementMap;
    private Map<InetAddress, UUID> ipAddressUUIDMap;
    public Network(){
        pathElementMap = new HashMap<UUID,PathElement>();
        ipAddressUUIDMap = new HashMap<InetAddress, UUID>();
    }
    //получить все элементы данной сети с их id (<id экземпляра класса, этот экземпляр>)
    public Map<UUID, PathElement> getPathElements(){
        return pathElementMap;
    }

    public Map<InetAddress, UUID> getIpAddressUUIDMap(){
        return ipAddressUUIDMap;
    }

    public void add(UUID id, PathElement pathElement){
        if (pathElement == null || id == null) throw new IllegalArgumentException();
        //ещё нельзя добавлять ActiveElement у которого ipAddress == null
        else {
            pathElementMap.put(id, pathElement);
            if (pathElement instanceof ActiveElement)
                ipAddressUUIDMap.put(((ActiveElement) pathElement).ipAddress, id);
        }
    }

    public void remove(UUID id){
        if (!pathElementMap.containsKey(id)) throw new IllegalArgumentException();
        else {
            PathElement elementValue = pathElementMap.get(id);
            if (elementValue instanceof ActiveElement)
                ipAddressUUIDMap.remove(((ActiveElement) elementValue).ipAddress);
            for (PathElement elem: pathElementMap.values()) {
                if (elem.getConnections().contains(elementValue)) elem.removeConnection(elementValue);
            }
            pathElementMap.remove(id);
        }
    }
}
