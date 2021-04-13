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
        List <Cable> list1 = new ArrayList<>();
        UUID id1 = PathElement.generateID();
        Switch switch1 = new Switch(0.0, 0.6, id1, list1, InetAddress.getLocalHost());

        UUID id2 = PathElement.generateID();
        List <Cable> list2 = new ArrayList<>();
        Router router1 = new Router(0.0, 0.9, id2, list2, InetAddress.getLocalHost());

        List <Cable> list3 = new ArrayList<>();
        UUID id3 = PathElement.generateID();
        Firewall firewall1 = new Firewall(0.0, 0.3, id3, list3, InetAddress.getLocalHost());

        List <Cable> list4 = new ArrayList<>();
        UUID id4 = PathElement.generateID();
        Switch switch2 = new Switch(0.0, 0.6, id4, list4, InetAddress.getLocalHost());

        UUID id5 = PathElement.generateID();
        List <Cable> list5 = new ArrayList<>();
        Router router2 = new Router(0.0, 0.9, id5, list5, InetAddress.getLocalHost());

        List <Cable> list6 = new ArrayList<>();
        UUID id6 = PathElement.generateID();
        Firewall firewall2 = new Firewall(0.0, 0.3, id6, list6, InetAddress.getLocalHost());




        List <PathElement> cableList1 = new ArrayList<>();
        Cable coaxialCable1 = new CoaxialCable(0.0,0.7, cableList1);

        List <PathElement> cableList2 = new ArrayList<>();
        Cable stpCable1 = new StpCable(0.0,0.8, cableList2);

        List <PathElement> cableList3 = new ArrayList<>();
        Cable utpCable1 = new UtpCable(0.0,0.5, cableList3);

        List <PathElement> cableList4 = new ArrayList<>();
        Cable coaxialCable2 = new CoaxialCable(0.0,0.7, cableList4);

        List <PathElement> cableList5 = new ArrayList<>();
        Cable stpCable2 = new StpCable(0.0,0.8, cableList5);

        List <PathElement> cableList6 = new ArrayList<>();
        Cable utpCable2 = new UtpCable(0.0,0.5, cableList6);

        List <PathElement> cableList7 = new ArrayList<>();
        Cable coaxialCable3 = new CoaxialCable(0.0,0.7, cableList7);

        List <PathElement> cableList8 = new ArrayList<>();
        Cable stpCable3 = new StpCable(0.0,0.8, cableList8);


        /*coaxialCable1.addConnection(router1);
        coaxialCable1.addConnection(switch1);

        coaxialCable2.addConnection(switch1);
        coaxialCable2.addConnection(firewall1);

        coaxialCable3.addConnection(firewall1);
        coaxialCable3.addConnection(switch2);

        stpCable1.addConnection(switch2);
        stpCable1.addConnection(router2);

        stpCable2.addConnection(router2);
        stpCable2.addConnection(firewall2);

        stpCable3.addConnection(firewall2);
        stpCable3.addConnection(router1);

        utpCable1.addConnection(switch1, );


        Network net = new Network("timeDelay");
        net.add(router.getID(), router);
        net.add(firewall.getID(), firewall);
        net.add(switch1.getID(), switch1);
        net.add(coaxialCable);
        net.add(stpCable);
        net.add(utpCable);

        RouteProvider.getRoute(router.getID(), switch1.getID(), net);*/



        //создание объекта для сериализации в JSON
        //Cat cat = new Cat();
        //cat.name = "Murka";
        //cat.age = 5;
        //cat.weight = 4;


       // FileOutputStream w = new FileOutputStream("C://Users//bebes//IdeaProjects//NetworkModel//output.txt");

        //StringWriter writer = new StringWriter();

        //JsonFactory factory = new JsonFactory();

        //JsonGenerator generator = factory.createGenerator(w);
        //jsonGen.setCodec (новый ObjectMapper ());
       // generator.setCodec(null).writeObject(cat);
        //generator.writeObject(cat);

        //http://fasterxml.github.io/jackson-core/javadoc/2.12/
        //http://fasterxml.github.io/jackson-core/javadoc/2.12/
        //ObjectMapper mapper = new ObjectMapper();

       // mapper.writeValue(writer, cat);


       // String result = writer.toString();
        //System.out.println(result);

    }
}

//@JsonAutoDetect
//class Cat
//{
//    public String name;
//    public int age;
//    public int weight;
//    Cat(){}
//}

