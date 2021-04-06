package albe;
import albe.model.*;
import sun.nio.ch.Net;

import java.util.ArrayList;
import java.util.UUID;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List <PathElement> list1 = new ArrayList<>();
        UUID id1 = PathElement.generateID();
        Cable cabel = new Cable(0.1, 0.2, id1, list1);

        UUID id2 = PathElement.generateID();
        List <PathElement> list2 = new ArrayList<>();
        Router router = new Router(0.2, 0.3, id2, list2, null);

        Network network = new Network();
        network.add(cabel);
        network.add(router);
        System.out.println(network.getPathElements());

        cabel.addConnection(router);
        System.out.println(cabel.getConnections());
        System.out.println(router.getConnections());

        network.remove(router);
        System.out.println(network.getPathElements());
        System.out.println(cabel.getConnections());
    }
}
