
import NetworkModel.*;
import NetworkModel.Example.BasicClass;
import NetworkModel.Example.ClassHolder;
import NetworkModel.Example.ExtendedClass;
import NetworkModel.Example.SuperExtendedClass;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import static com.fasterxml.jackson.databind.SerializationFeature.INDENT_OUTPUT;

public class Main {

    public static void main(String[] args) throws RouteNotFoundException, UnknownHostException, IOException {

        UUID id1 = PathElement.generateID();
        Switch switch1 = new Switch(1.0, 2.0, id1, PathElement.generateIP());

        UUID id2 = PathElement.generateID();
        Firewall firewall1 = new Firewall(3.0, 4.0, id2, PathElement.generateIP());

        Cable coaxideCable1 = new CoaxialCable(6.0, 4.0, switch1, firewall1);

        UUID id3 = PathElement.generateID();
        Router router1 = new Router(5.0, 6.0, id3, PathElement.generateIP());

        StpCable stpCable1 = new StpCable(1.0, 2.0, firewall1, router1);

        UUID id4 = PathElement.generateID();
        Hub hub1 = new Hub(9.0, 1.0, id4);

        UtpCable utpCable1 = new UtpCable(7.0, 8.0, router1, hub1);
        CoaxialCable coaxialCable2 = new CoaxialCable(1.1, 2.2, firewall1, hub1);

        UUID id5 = PathElement.generateID();
        PC pc1 = new PC(1.3, 1.7, id5, PathElement.generateIP());

        StpCable stpCable2 = new StpCable(5.0, 8.0, hub1, pc1);

        UUID id6 = PathElement.generateID();
        Hub hub2 = new Hub(1.5, 1.9, id6);

        UtpCable utpCable2 = new UtpCable(2.0, 2.1, pc1, hub2);
        CoaxialCable coaxialCable3 = new CoaxialCable(5.0, 8.0, hub2, switch1);

        Network net = new Network();
        net.add(switch1.getID(), switch1);
        net.add(firewall1.getID(), firewall1);
        net.add(router1.getID(), router1);
        net.add(hub1.getID(), hub1);
        net.add(pc1.getID(), pc1);
        net.add(hub2.getID(), hub2);

        net.add(coaxideCable1);
        net.add(stpCable1);
        net.add(utpCable1);
        net.add(coaxialCable2);
        net.add(stpCable2);
        net.add(utpCable2);
        net.add(coaxialCable3);


        RouteProvider providerCosts = new RouteProviderCosts();
        RouteProvider providerTimeDelay = new RouteProviderTimeDelay();

        //List<PathElement> resPath = providerTimeDelay.getRoute(switch1.getID(), router1.getID(), net);


        FileOutputStream w = new FileOutputStream("C://Users//bebes//IdeaProjects//NetworkModelNew//output.txt");

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        String serializedString = mapper.writeValueAsString(net);

        JsonFactory factory = new JsonFactory();
        JsonGenerator generator = factory.createGenerator(w);
        generator.setCodec (new ObjectMapper ());

        generator.writeObject(net);

        System.out.println(serializedString);

        Network resultNet = mapper.readValue(serializedString, Network.class);

        System.out.println(resultNet);

        //сериализуем результат десериализации

        FileOutputStream writer = new FileOutputStream("C://Users//bebes//IdeaProjects//NetworkModelNew//output2.txt");

        JsonGenerator gen = factory.createGenerator(writer);
        gen.setCodec (new ObjectMapper ());
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        String serializedStr = mapper.writeValueAsString(resultNet);
        System.out.println(serializedStr);
        gen.writeObject(resultNet);

        //List<PathElement> resPath2 = providerTimeDelay.getRoute(switch1.getID(), router1.getID(), resultNet);











    }


}

