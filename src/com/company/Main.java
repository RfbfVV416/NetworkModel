package com.company;

import java.util.*;



public class Main {

    public static void main(String[] args) {


    }
}

interface RouteProvider{
    //найти маршрут между элементами сети
    //public static List<PathElement> getRoute(Integer firstID, Integer secondID, Network net){
        //return List<PathElement> or throws RouteNotFoundException
    //}
    //описание
    public static String getDescription(){
        return "Use RouteProvider.getRoute(Integer firstID, Integer secondID, Network net) \n" +
                "to find the route between path elements of network \n";
    }
}


class Network implements RouteProvider{
    private ArrayList<PathElement> pathElementList; //список эл данной сети (список из экземпляров классов Hub, PC, Switch и т д)
    Network(){
        pathElementList = new ArrayList<PathElement>();
    }
    //получить все элементы данной сети с их id (<id экземпляра класса, этот экземпляр>)
    public HashMap<Integer, PathElement> getPathElements(){
        HashMap<Integer, PathElement> networkElems = new HashMap<Integer,PathElement>();
        for(PathElement elem: pathElementList){
            networkElems.put(elem.getID(), elem);
        }
        return networkElems;
    }

    //добавить эл в pathElementList
    public void add (PathElement elem){
        if (elem == null) throw new IllegalArgumentException();
        else pathElementList.add(elem);
    }
    //удалить эл из pathElementList
    public void remove (PathElement elem){
        if (!pathElementList.contains(elem)) throw new IllegalArgumentException();
        else pathElementList.remove(elem);
    }
}

interface PathElement{

    public Double getTimeDelay();
    public Double getCosts();
    //public ArrayList<PathElement> getConnections();
    public String getInfo();
    public Integer getID();

}

class PassiveElement implements PathElement{
    protected Double timeDelay;
    protected Double costs;

    PassiveElement(Double timeDelay, Double costs){
        this.timeDelay = timeDelay;
        this.costs = costs;
    }

    public Double getTimeDelay(){
        return timeDelay;
    }
    public Double getCosts(){
        return costs;
    }
    public String getInfo(){
        return "This is a passive element";
    }
    public Integer getID(){
        return this.hashCode();
    }
    //public ArrayList<PathElement> getConnections(){

    //}
}

class ActiveElement implements PathElement{
    protected Double timeDelay;
    protected Double costs;

    ActiveElement(Double timeDelay, Double costs){
        this.timeDelay = timeDelay;
        this.costs = costs;
    }

    public Double getTimeDelay(){
        return timeDelay;
    }
    public Double getCosts(){
        return costs;
    }
    public String getInfo(){
        return "This is an active element";
    }
    public Integer getID(){
        return this.hashCode();
    }

    //public ArrayList<PathElement> getConnections(){

    //}

   // public ArrayList<IPAddress> getIP(){
        //return
    //}

}

class Cable extends PassiveElement{
    Cable(Double timeDelay, Double costs){
        super(timeDelay, costs);
    }

}

class Hub extends PassiveElement{
    Hub(Double timeDelay, Double costs){
        super(timeDelay, costs);
    }

}

class Router extends  ActiveElement{
    Router(Double timeDelay, Double costs){
        super(timeDelay, costs);
    }

}

class Switch extends ActiveElement{
    Switch(Double timeDelay, Double costs){
        super(timeDelay, costs);
    }

}

class PC extends ActiveElement{
    PC(Double timeDelay, Double costs){
        super(timeDelay, costs);
    }

}

class Firewall extends ActiveElement{
    Firewall(Double timeDelay, Double costs){
        super(timeDelay, costs);
    }

}
