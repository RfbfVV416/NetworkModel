package albe.model;
import java.util.*;
import java.util.UUID;

public class Network implements RouteProvider{
    private List<PathElement> pathElementList; //список эл данной сети (список из экземпляров классов Hub, PC, Switch и т д)
    public Network(){

        pathElementList = new ArrayList<PathElement>();
    }
    //получить все элементы данной сети с их id (<id экземпляра класса, этот экземпляр>)
    public Map<UUID, PathElement> getPathElements(){
        Map<UUID, PathElement> networkElems = new HashMap<UUID,PathElement>();
        for(PathElement elem: pathElementList){
            networkElems.put(elem.getID(), elem);
        }
        return networkElems;
    }

    //добавить эл в pathElementList
    public void add(PathElement elem){
        if (elem == null) throw new IllegalArgumentException();
        else pathElementList.add(elem);
    }
    //удалить эл из pathElementList
    public void remove(PathElement elem){
        if (!pathElementList.contains(elem)) throw new IllegalArgumentException();
        else {
            for (PathElement pathEl: pathElementList) {
                if (pathEl.getConnections().contains(elem)) pathEl.removeConnection(elem);
            }
            pathElementList.remove(elem);
        }
    }
}
