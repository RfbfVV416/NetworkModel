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
        Switch switch1 = new Switch(0.2, 0.3, id1, list1, InetAddress.getLocalHost());

        UUID id2 = PathElement.generateID();
        List <Cable> list2 = new ArrayList<>();
        Router router = new Router(0.2, 0.3, id2, list2, InetAddress.getLocalHost());

        List <Cable> list3 = new ArrayList<>();
        UUID id3 = PathElement.generateID();
        Firewall firewall = new Firewall(0.2, 0.3, id1, list3, InetAddress.getLocalHost());

        List <PathElement> cableList = new ArrayList<>();
        Cable coaxialCable = new CoaxialCable(0.1,0.7, cableList);
        switch1.addConnection(coaxialCable);
        router.addConnection(coaxialCable);
        System.out.println(switch1.getConnections());
        System.out.println(router.getConnections());
        System.out.println(coaxialCable.getConnections());




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
class Cat
{
    public String name;
    public int age;
    public int weight;
    Cat(){}
}

