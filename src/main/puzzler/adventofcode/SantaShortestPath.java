package puzzler.adventofcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import algorithm.graph.travellingsalesmanproblem.BruteForceTCP;
import algorithm.graph.travellingsalesmanproblem.TravellingSalesmanProblem;
import algorithm.structure.graph.Graph;
import algorithm.structure.graph.Vertex;
import algorithm.structure.graph.WeightedEdge;
import algorithm.structure.graph.adjacency.list.AdjacencyListDirectedGraph;

/**
 * @author Sergey Kuptsov
 * @since 18/04/2016
 */
public class SantaShortestPath {

    public static void main(String[] args) throws IOException {

        BufferedReader sc = new BufferedReader(new InputStreamReader(SantaShortestPath.class.getResourceAsStream("/santaCities")));

        Graph<String, Vertex<String>, WeightedEdge<String>> graph = new AdjacencyListDirectedGraph<>();

        String line;
        while ((line = sc.readLine()) != null) {

            String[] params = line.split(" ");
            Vertex<String> first = new Vertex<>(params[0]);
            Vertex<String> second = new Vertex<>(params[2]);

            graph.addEdge(new WeightedEdge<>(first, second, new Double(params[4])));
            graph.addEdge(new WeightedEdge<>(second, first, new Double(params[4])));
        }

        TravellingSalesmanProblem<String> tcp = new BruteForceTCP<>(graph);

        List<WeightedEdge<String>> path = tcp.buildShortestRoute();
        path.forEach(e -> System.out.println(e.getFromV().getValue() + " -> " + e.getToV().getValue() + " " + e.getWeight()));

        System.out.println(path.stream().map(WeightedEdge::getWeight).reduce((a, b) -> a + b).get());
    }
}
