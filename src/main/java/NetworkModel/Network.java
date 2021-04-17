package NetworkModel;

import java.util.*;
import java.util.UUID;
import java.net.InetAddress;

public class Network implements RouteProvider{
    private Map<UUID, PathElement> pathElementMap;
    private Map<InetAddress, UUID> ipAddressUUIDMap;
    private Set<Cable> cabelsSet;
    private String weight;

    public Network(String weight){
        pathElementMap = new HashMap<UUID,PathElement>();
        ipAddressUUIDMap = new HashMap<InetAddress, UUID>();
        cabelsSet = new HashSet<>();
        this.weight = weight;
    }

    public Map<UUID, PathElement> getPathElements(){ return pathElementMap; }
    public Map<InetAddress, UUID> getIpAddressUUIDMap(){ return ipAddressUUIDMap; }
    public Set<Cable> getCabelsSet(){ return cabelsSet; }
    public String getWeight() { return weight; }
    public void setWeight(String weight) { this.weight = weight; }

    public void add(UUID id, PathElement pathElement){
        if (pathElement == null || id == null) throw new IllegalArgumentException();
            //ещё нельзя добавлять ActiveElement у которого ipAddress == null
        else {
            pathElementMap.put(id, pathElement);
            if (pathElement instanceof ActiveElement)
                ipAddressUUIDMap.put(((ActiveElement) pathElement).ipAddress, id);
        }
    }
    //нельзя добавить два одинаковых ребра в список кабелей
    //не должно быть в итоговом списке связности ребер соединяющих что-то и пустоту
    //и то и друго проще ловить в RouteProvider

    public void add(Cable cable){
        if (cable == null) throw new IllegalArgumentException();
        else cabelsSet.add(cable);
    }


    public void remove(UUID id){
//        if (!pathElementMap.containsKey(id)) throw new IllegalArgumentException();
//        else {
//            PathElement elementValue = pathElementMap.get(id);
//            if (elementValue instanceof ActiveElement)
//                ipAddressUUIDMap.remove(((ActiveElement) elementValue).ipAddress);
//            for (Cable cable: cabelsList) {
//                if (cable.getConnections().contains(elementValue)){
//
//                }
//            }
//            for (PathElement elem: pathElementMap.values()) {
//                if (elem.getConnections().contains(elementValue)) elem.removeConnection(elementValue);
//            }
//            pathElementMap.remove(id);
//        }
    }


}

