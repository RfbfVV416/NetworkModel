package albe.model;
import java.util.*;

public class Network implements RouteProvider{
    private List<PathElement> pathElementList; //список эл данной сети (список из экземпляров классов Hub, PC, Switch и т д)
    Network(){
        pathElementList = new ArrayList<PathElement>();
    }
    //получить все элементы данной сети с их id (<id экземпляра класса, этот экземпляр>)
    public Map<String, PathElement> getPathElements(){
        Map<String, PathElement> networkElems = new HashMap<String,PathElement>();
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
        else pathElementList.remove(elem);
    }
}
