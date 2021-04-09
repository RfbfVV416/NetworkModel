package albe;
import albe.model.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.type.ResolvedType;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        List <PathElement> list1 = new ArrayList<>();
        UUID id1 = PathElement.generateID();
        Cable cabel = new Cable(0.1, 0.2, id1, list1);

        UUID id2 = PathElement.generateID();
        List <PathElement> list2 = new ArrayList<>();
        Router router = new Router(0.2, 0.3, id2, list2, null);

        Network network = new Network();
        network.add(id1, cabel);
        network.add(id2, router);
        System.out.println(network.getPathElements());

    }
}

