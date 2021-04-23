
import NetworkModel.*;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.UUID;


public class Main {
    public Double func(Double pathElement1, Double cable, Double pathElement2){
        return 0.1;
    }

    public static void main(String[] args) throws RouteNotFoundException, UnknownHostException{

        UUID id1 = PathElement.generateID();
        Switch switch1 = new Switch(1.0, 2.0, id1, InetAddress.getLocalHost());

        UUID id2 = PathElement.generateID();
        Firewall firewall1 = new Firewall(3.0, 4.0, id2, InetAddress.getLocalHost());

        Cable coaxideCable1 = new CoaxialCable(6.0, 4.0, switch1, firewall1);

        UUID id3 = PathElement.generateID();
        Router router1 = new Router(5.0, 6.0, id3, InetAddress.getLocalHost());

        StpCable stpCable1 = new StpCable(1.0, 2.0, firewall1, router1);

        UUID id4 = PathElement.generateID();
        Hub hub1 = new Hub(9.0, 1.0, id4);

        UtpCable utpCable1 = new UtpCable(7.0, 8.0, router1, hub1);
        CoaxialCable coaxialCable2 = new CoaxialCable(1.1, 2.2, firewall1, hub1);

        UUID id5 = PathElement.generateID();
        PC pc1 = new PC(1.3, 1.7, id5, InetAddress.getLocalHost());

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



        RouteProviderCosts providerCosts = new RouteProviderCosts();
        RouteProviderTimeDelay providerTimeDelay = new RouteProviderTimeDelay();
        WeightFunction<PathElement, Cable, PathElement, Double> weightFunction = providerTimeDelay.getWeightFunction();

        List<PathElement> resPath = RouteProvider.getRoute(switch1.getID(), router1.getID(), net, weightFunction);







    }

}

