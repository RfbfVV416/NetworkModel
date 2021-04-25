package NetworkModel;

import java.util.*;
import java.util.UUID;

public class Network{
    private Map<UUID, PathElement> pathElementMap;
    private Map<String, UUID> ipAddressUUIDMap;
    private Set<Cable> cablesSet;

    public Network(){
        pathElementMap = new HashMap<UUID,PathElement>();
        ipAddressUUIDMap = new HashMap<String, UUID>();
        cablesSet = new HashSet<>();
    }

    public Map<UUID, PathElement> getPathElements(){ return pathElementMap; }
    public Map<String, UUID> getIpAddressUUIDMap(){ return ipAddressUUIDMap; }
    public Set<Cable> getCablesSet(){ return cablesSet; }

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
        else cablesSet.add(cable);
    }

}

