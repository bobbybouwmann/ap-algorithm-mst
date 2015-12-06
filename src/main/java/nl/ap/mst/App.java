package nl.ap.mst;

import nl.ap.mst.Graph.Graph;
import nl.ap.mst.Graph.Node;

import java.util.List;
import java.util.Random;

public class App {
    public static void main(String [] args) {
        MST min_spanning_tree = new MST(); // our calculator

        Graph connected_graph = new Graph();

        int max_nodes = 10;

        for (int i = 0; i < max_nodes; i++) {
            Node aNode = new Node();
            aNode.value = i;
            aNode.x = i;
            aNode.y = i+1;
            connected_graph.Nodes.add(aNode);
        }

        Random rn = new Random();

        int minConnectedTo = 0;
        for (Node aNode: connected_graph.Nodes) {
            if (minConnectedTo < max_nodes-1) {
                aNode.connect(connected_graph.Nodes.get(minConnectedTo + 1));
            }
            int nodeI = rn.nextInt(max_nodes);
            for (int i = 0; i < 1; i++) {
                aNode.connect(connected_graph.Nodes.get(nodeI));
            }
        }
        connected_graph.Print();

        List<Node> tree = min_spanning_tree.Get(connected_graph);

        System.out.println("Tree length: " + tree.size());

    }
}
