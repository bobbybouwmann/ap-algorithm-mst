package nl.ap.mst;

import nl.ap.mst.Graph.Graph;
import nl.ap.mst.Graph.Node;
import nl.ap.mst.Tree.Tree;

import java.util.List;
import java.util.Random;

public class App {
    public static void main(String [] args) {
        MST min_spanning_tree = new MST(); // our calculator
        int max_nodes = 10;
        Graph connected_graph = new Graph();

        // Node A
        Node n = new Node();
        n.value = 0;
        n.x = 1;
        n.y = 0;
        connected_graph.Nodes.add(n);

        // Node B
        n = new Node();
        n.value = 1;
        n.x = 4;
        n.y = 2;
        connected_graph.Nodes.add(n);

        // Node C
        n = new Node();
        n.value = 2;
        n.x = 2;
        n.y = 4;
        connected_graph.Nodes.add(n);

        // Node D
        n = new Node();
        n.value = 3;
        n.x = 6;
        n.y = 0;
        connected_graph.Nodes.add(n);

        // Node E
        n = new Node();
        n.value = 4;
        n.x = 0;
        n.y = 7;
        connected_graph.Nodes.add(n);

        // Node F
        n = new Node();
        n.value = 5;
        n.x = 6;
        n.y = 5;
        connected_graph.Nodes.add(n);

        // Node G
        n = new Node();
        n.value = 6;
        n.x = 4;
        n.y = 6;
        connected_graph.Nodes.add(n);

        // Connect A to B (0 to 1)
        connected_graph.Nodes.get(0).connect(connected_graph.Nodes.get(1));

        // Connect A to C (0 to 2)
        connected_graph.Nodes.get(0).connect(connected_graph.Nodes.get(2));

        // Connect B to D (1 to 3)
        connected_graph.Nodes.get(1).connect(connected_graph.Nodes.get(3));

        // Connect B to C (1 to 2)
        connected_graph.Nodes.get(1).connect(connected_graph.Nodes.get(2));

        // Connect B to F (1 to 5)
        connected_graph.Nodes.get(1).connect(connected_graph.Nodes.get(5));

        // Connect D to F (3 to 5)
        connected_graph.Nodes.get(3).connect(connected_graph.Nodes.get(5));

        // Connect C to E (2 to 4)
        connected_graph.Nodes.get(2).connect(connected_graph.Nodes.get(4));

        // Connect C to G (2 to 6)
        connected_graph.Nodes.get(2).connect(connected_graph.Nodes.get(6));

        // Connect E to G (4 to 6)
        connected_graph.Nodes.get(4).connect(connected_graph.Nodes.get(6));

        // Connect C to G (2 to 6)
        connected_graph.Nodes.get(2).connect(connected_graph.Nodes.get(6));

        // Connect F to G (5 to 6)
        connected_graph.Nodes.get(5).connect(connected_graph.Nodes.get(6));

        Tree.Print(connected_graph.Nodes, max_nodes, max_nodes);

        for (Node node : connected_graph.Nodes) {
            System.out.println("NODE: " + node.value);
            for (Node conn : node.connectedTo) {
                System.out.println("\t"+conn.value+" dist:" + node.DistanceTo(conn));
            }
        }

        Tree tree = min_spanning_tree.Get(connected_graph);

        System.out.println("Tree length: " + tree.size());
        System.out.println("--------------------------");
        Tree.Print(tree, max_nodes, max_nodes);
    }
}
