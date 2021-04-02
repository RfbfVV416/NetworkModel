package albe;
import albe.model.*;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<PathElement> connections1 = new ArrayList<>(); //пустой список связей
        ArrayList<PathElement> connections2 = new ArrayList<>();
        ArrayList<PathElement> connections3 = new ArrayList<>();
        Cable pe = new Cable(0.1, 0.2, connections1);
        Hub pe2 = new Hub(0.9,0.8, connections2);
        Cable pe3 = new Cable(0.8, 0.9, connections3);
        pe.addConnection(pe2);

        System.out.println(pe.getID());
        System.out.println(pe.getID());
        System.out.println(pe2.getID());
        System.out.println(pe3.getID());

    }
}
