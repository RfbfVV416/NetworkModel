package albe.model;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;
import java.util.UUID;


public class WeightedOrientedGraph {
    static class Edge{
        UUID from;
        UUID to;
        Double timeDelay;
        Double costs;

        Edge(UUID from, UUID to, Double timeDelay, Double costs){
            this.from = from;
            this.to = to;
            this.timeDelay = timeDelay;
            this.costs = costs;
        }
    }

    static class Graph{
        Map<UUID, List<Edge>> adjacencyList = new HashMap<>();

        Graph(Network network){
            for (PathElement pathElement: network.getPathElements().values()) { //для каждого элемента сети
                List<Edge> listOfEdges = new LinkedList<>(); //список ребер исходящих из текущей вершины
                for (PathElement connection: pathElement.getConnections()) { //для каждого элемента связанного с текущим
                    UUID firstVert = pathElement.getID();
                    UUID secondVert = connection.getID();
                    Edge edge = new Edge(firstVert, secondVert, pathElement.getTimeDelay(), pathElement.getCosts());
                    listOfEdges.add(edge);
                }
                adjacencyList.put(pathElement.getID(), listOfEdges);
            }
        }
    }
}
