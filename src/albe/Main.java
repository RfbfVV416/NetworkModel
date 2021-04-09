package albe;
import albe.model.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.type.ResolvedType;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.*;
import java.net.InetAddress;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        List <PathElement> list1 = new ArrayList<>();
        UUID id1 = PathElement.generateID();
        Cable cabel = new Cable(0.1, 0.2, id1, list1);

        UUID id2 = PathElement.generateID();
        List <PathElement> list2 = new ArrayList<>();
        Router router = new Router(0.2, 0.3, id2, list2, InetAddress.getLocalHost());

        Network network = new Network();
        network.add(id1, cabel);
        network.add(id2, router);
        System.out.println(network.getPathElements());
        System.out.println(network.getIpAddressUUIDMap());

        cabel.addConnection(router);
        System.out.println(cabel.getConnections());
        System.out.println(router.getConnections());

        network.remove(id2);
        System.out.println(network.getPathElements());
        System.out.println(cabel.getConnections());
        System.out.println(network.getIpAddressUUIDMap());


    }
}

