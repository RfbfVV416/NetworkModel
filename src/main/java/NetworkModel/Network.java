package NetworkModel;

import java.util.*;
import java.util.UUID;
import java.net.InetAddress;

public class Network{
    private Map<UUID, PathElement> pathElementMap;
    private Map<InetAddress, UUID> ipAddressUUIDMap;
    private Set<Cable> cabelsSet;

    public Network(){
        pathElementMap = new HashMap<UUID,PathElement>();
        ipAddressUUIDMap = new HashMap<InetAddress, UUID>();
        cabelsSet = new HashSet<>();
    }

    public Map<UUID, PathElement> getPathElements(){ return pathElementMap; }
    public Map<InetAddress, UUID> getIpAddressUUIDMap(){ return ipAddressUUIDMap; }
    public Set<Cable> getCabelsSet(){ return cabelsSet; }

    public void add(UUID id, PathElement pathElement){
        if (pathElement == null || id == null) throw new IllegalArgumentException();
            //ещё нельзя добавлять ActiveElement у которого ipAddress == null
        else {
            pathElementMap.put(id, pathElement);
            if (pathElement instanceof ActiveElement)
                ipAddressUUIDMap.put(((ActiveElement) pathElement).ipAddress, id);
        }
    }

    public void add(Cable cable){
        if (cable == null) throw new IllegalArgumentException();
        else cabelsSet.add(cable);
    }

}

