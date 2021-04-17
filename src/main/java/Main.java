
import NetworkModel.*;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.UUID;


public class Main {
    public Double func(Double pathElement1, Double cable, Double pathElement2){
        return 0.1;
    }

    public static void main(String[] args) throws UnknownHostException {
      

        UUID id1 = PathElement.generateID();
        Switch switch1 = new Switch(0.0, 0.6, id1, InetAddress.getLocalHost());

        UUID id2 = PathElement.generateID();
        Router router1 = new Router(0.0, 0.9, id2, InetAddress.getLocalHost());

        UUID id3 = PathElement.generateID();
        Firewall firewall1 = new Firewall(0.0, 0.9, id3, InetAddress.getLocalHost());

        Cable coaxideCable = new CoaxialCable(0.1, 0.2, switch1, firewall1);
        Cable stpCable = new StpCable(0.2, 0.9, firewall1, router1);
        Cable utpCable = new UtpCable(0.4, 0.6, switch1, router1);

        Network net = new Network("timeDelay");
        net.add(switch1.getID(), switch1);
        net.add(router1.getID(), router1);
        net.add(firewall1.getID(), firewall1);
        net.add(coaxideCable);
        net.add(stpCable);
        net.add(utpCable);
        RouteProvider.getRoute(switch1.getID(), router1.getID(), net);






    }

}

