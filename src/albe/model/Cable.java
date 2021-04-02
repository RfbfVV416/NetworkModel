package albe.model;

import java.util.ArrayList;

public class Cable extends PassiveElement{
    public Cable(Double timeDelay, Double costs, ArrayList<PathElement> connections){
        super(timeDelay, costs, connections);
    }

}
