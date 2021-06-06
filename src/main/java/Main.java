import NetworkModel.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;

public class Main {



    public static void main(String[] args) throws RouteNotFoundException, IOException, NoSuchFieldException, IllegalAccessException{

          Logger logger = LoggerFactory.getLogger(Main.class);
        String strForDeserialization = "";
        try(FileInputStream fileInputStream = new FileInputStream("C://Users//bebes//IdeaProjects//NetworkModelNew//input.txt")){
            int i;

            while((i=fileInputStream.read())!= -1){
                char x = (char)i;
                strForDeserialization += (char)i;
            }
        }
        catch (IOException exception){
            exception.printStackTrace();
        }

        ObjectMapper mapper = new ObjectMapper();
        Network net = mapper.readValue(strForDeserialization, Network.class);
        logger.debug("Object was read successfully");

        logger.debug("Available ip addresses");
        for (String ip: net.getIpAddressUUIDMap().keySet()) {
            logger.debug(ip);
        }

        RouteProvider providerCosts = new RouteProviderCosts();
        RouteProvider providerTimeDelay = new RouteProviderTimeDelay();
        String firstIP;
        String secondIP;
        String param;
        Scanner in = new Scanner(System.in);
        while(true){
            firstIP = in.nextLine();
            secondIP = in.nextLine();
            param = in.nextLine();
            break;
        }

        List<PathElement> resPath = null;
        if ("costs".equals(param)){
            resPath = providerCosts.getRoute(firstIP, secondIP, net);
        }
        else if ("timeDelay".equals(param)){
            resPath = providerTimeDelay.getRoute(firstIP, secondIP, net);
        }

        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        String serializedStr= mapper.writeValueAsString(resPath);

        try(FileOutputStream out = new FileOutputStream("C://Users//bebes//IdeaProjects//NetworkModelNew//output.txt")){
            out.write(serializedStr.getBytes());
        }
        catch (IOException exception){
            exception.printStackTrace();
        }

    }
}

    /*//0
    PathElement switch01_03 = new Switch(1.0, 3.0, PathElement.generateID(), PathElement.generateIP());
    //1
    PathElement router14_16 = new Router(4.0, 6.0, PathElement.generateID(), PathElement.generateIP());
    //2
    PathElement hub21_28 = new Hub(1.0, 8.0, PathElement.generateID());
    //3
    PathElement pc39_35 = new PC(9.0, 5.0, PathElement.generateID(), PathElement.generateIP());
    //4
    PathElement firewall44_42 = new Firewall(4.0, 2.0, PathElement.generateID(), PathElement.generateIP());
    //5
    PathElement switch53_52 = new Switch(3.0, 2.0, PathElement.generateID(), PathElement.generateIP());
    //6
    PathElement router64_62 = new Router(4.0, 2.0, PathElement.generateID(), PathElement.generateIP());
    //7
    PathElement hub72_74 = new Hub(2.0, 4.0, PathElement.generateID());
    //8
    PathElement pc81_83 = new PC(1.0, 3.0, PathElement.generateID(), PathElement.generateIP());
    //9
    PathElement firewall96_99 = new Firewall(6.0, 9.0, PathElement.generateID(), PathElement.generateIP());
    //10
    PathElement switch107_102 = new Switch(7.0, 2.0, PathElement.generateID(), PathElement.generateIP());
    //11
    PathElement router118_117 = new Router(8.0, 7.0, PathElement.generateID(), PathElement.generateIP());
    //12
    PathElement hub128_129 = new Hub(8.0, 9.0, PathElement.generateID());
    //13
    PathElement pc135_133 = new PC(5.0, 3.0, PathElement.generateID(), PathElement.generateIP());
    //14
    PathElement firewall141_143 = new Firewall(1.0, 3.0, PathElement.generateID(), PathElement.generateIP());
    //15
    PathElement switch152_155 = new Switch(2.0, 5.0, PathElement.generateID(), PathElement.generateIP());
    //16
    PathElement router161_164 = new Router(1.0, 4.0, PathElement.generateID(), PathElement.generateIP());
    //17
    PathElement hub173_174 = new Hub(3.0, 4.0, PathElement.generateID());
    //18
    PathElement pc185_187 = new PC(5.0, 7.0, PathElement.generateID(), PathElement.generateIP());

    //0
    Cable cc1 = new CoaxialCable(3.0, 1.0, switch01_03, router14_16);
    Cable stp1 = new StpCable(5.0, 3.0, switch01_03, hub21_28);
    Cable utp1 = new UtpCable(4.0, 5.0, switch01_03, pc39_35);
    //1
    Cable cc2 = new CoaxialCable(8.0, 5.0, router14_16, switch53_52);
    Cable stp2 = new StpCable(12.0, 10.0, router14_16, router64_62);
    Cable utp2 = new UtpCable(4.0, 5.0, router14_16, firewall44_42);
    //2
    Cable cc3 = new CoaxialCable(4.0, 3.0, hub21_28, firewall44_42);
    Cable utp11 = new UtpCable(9.0, 11.0, hub21_28, pc81_83);
    //3
    Cable stp3 = new StpCable(7.0, 5.0, pc39_35, hub72_74);
    Cable utp3 = new UtpCable(7.0, 3.0, pc39_35, pc81_83);
    //4
    Cable cc4 = new CoaxialCable(1.0, 4.0, firewall44_42, hub72_74);
    //5
    Cable stp4 = new StpCable(1.0, 4.0, switch53_52, switch107_102);
    Cable utp4 = new UtpCable(1.0, 7.0, switch53_52, firewall96_99);
    //6
    Cable cc5 = new CoaxialCable(1.0, 1.0, router64_62, firewall96_99);
    Cable stp5 = new StpCable(7.0, 2.0, router64_62, router118_117);
    Cable utp5 = new UtpCable(8.0, 3.0, router64_62, hub128_129);
    //7
    Cable cc6 = new CoaxialCable(5.0, 6.0, hub72_74, router118_117);
    Cable stp6 = new StpCable(10.0, 8.0, hub72_74, hub128_129);
    //8
    Cable utp6 = new UtpCable(6.0, 5.0, pc81_83, hub128_129);
    Cable cc7 = new CoaxialCable(4.0, 9.0, pc81_83, pc135_133);
    //9
    Cable stp7 = new StpCable(4.0, 5.0, firewall96_99, switch107_102);
    Cable utp7 = new UtpCable(2.0, 9.0, firewall96_99, firewall141_143);
    Cable cc8 = new CoaxialCable(12.0, 15.0, firewall96_99, pc185_187);
    //10
    Cable stp8 = new StpCable(16.0, 6.0, switch107_102, firewall141_143);
    //11
    Cable utp8 = new UtpCable(11.0, 5.0, router118_117, switch152_155);
    Cable cc9 = new CoaxialCable(5.0, 5.0, router118_117, router161_164);
    //12
    Cable stp9 = new StpCable(1.0, 8.0, hub128_129, switch152_155);
    //13
    Cable utp9 = new UtpCable(2.0, 3.0, pc135_133, switch152_155);
    Cable cc10 = new CoaxialCable(4.0, 3.0, pc135_133, router161_164);
    //14
    Cable stp10 = new StpCable(10.0, 8.0, firewall141_143, pc185_187);
    //15
    Cable utp10 = new UtpCable(3.0, 6.0, switch152_155, hub173_174);
    //16
    Cable cc11 = new CoaxialCable(4.0, 1.0, router161_164, hub173_174);
    //17
    Cable stp11 = new StpCable(8.0, 13.0, hub173_174, pc185_187);


    Network net = new Network();
    net.add(switch01_03.getID(), switch01_03);
    net.add(router14_16.getID(), router14_16);
    net.add(hub21_28.getID(), hub21_28);
    net.add(pc39_35.getID(), pc39_35);
    net.add(firewall44_42.getID(), firewall44_42);
    net.add(switch53_52.getID(), switch53_52);
    net.add(router64_62.getID(), router64_62);
    net.add(hub72_74.getID(), hub72_74);
    net.add(pc81_83.getID(), pc81_83);
    net.add(firewall96_99.getID(), firewall96_99);
    net.add(switch107_102.getID(), switch107_102);
    net.add(router118_117.getID(), router118_117);
    net.add(hub128_129.getID(), hub128_129);
    net.add(pc135_133.getID(), pc135_133);
    net.add(firewall141_143.getID(), firewall141_143);
    net.add(switch152_155.getID(), switch152_155);
    net.add(router161_164.getID(), router161_164);
    net.add(hub173_174.getID(), hub173_174);
    net.add(pc185_187.getID(), pc185_187);


    net.add(cc1);
    net.add(stp1);
    net.add(utp1);
    net.add(cc2);
    net.add(stp2);
    net.add(utp2);
    net.add(cc3);
    net.add(stp3);
    net.add(utp3);
    net.add(cc4);
    net.add(stp4);
    net.add(utp4);
    net.add(cc5);
    net.add(stp5);
    net.add(utp5);
    net.add(cc6);
    net.add(stp6);
    net.add(utp6);
    net.add(cc7);
    net.add(stp7);
    net.add(utp7);
    net.add(cc8);
    net.add(stp8);
    net.add(utp8);
    net.add(cc9);
    net.add(stp9);
    net.add(utp9);
    net.add(cc10);
    net.add(stp10);
    net.add(utp10);
    net.add(cc11);
    net.add(stp11);
    net.add(utp11);*/

