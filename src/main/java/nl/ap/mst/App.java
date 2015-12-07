package nl.ap.mst;

import nl.ap.mst.Graph.Graph;
import nl.ap.mst.Graph.Node;
import nl.ap.mst.Tree.Tree;

import java.util.List;
import java.util.Random;

public class App {
    public static void main(String [] args) {
        MST min_spanning_tree = new MST(); // our calculator

        Graph connected_graph = new Graph();

        int max_nodes = 10;

        Random rn = new Random();

        /*for (int i = 0; i < max_nodes; i++) {
            Node aNode = new Node();
            aNode.value = i;
            aNode.x = rn.nextInt(max_nodes);
            aNode.y = rn.nextInt(max_nodes);
            connected_graph.Nodes.add(aNode);
        }*/

        Node n = new Node();
        n.value = 0;
        n.x = 1;
        n.y = 2;
        connected_graph.Nodes.add(n);

        n = new Node();
        n.value = 1;
        n.x = 4;
        n.y = 5;
        connected_graph.Nodes.add(n);

        n = new Node();
        n.value = 2;
        n.x = 1;
        n.y = 6;
        connected_graph.Nodes.add(n);

        n = new Node();
        n.value = 3;
        n.x = 4;
        n.y = 8;
        connected_graph.Nodes.add(n);

        n = new Node();
        n.value = 4;
        n.x = 6;
        n.y = 9;
        connected_graph.Nodes.add(n);


        n = new Node();
        n.value = 5;
        n.x = 0;
        n.y = 1;
        connected_graph.Nodes.add(n);

        connected_graph.Nodes.get(0).connect(connected_graph.Nodes.get(1));
        connected_graph.Nodes.get(0).connect(connected_graph.Nodes.get(2));
        connected_graph.Nodes.get(2).connect(connected_graph.Nodes.get(3));
        connected_graph.Nodes.get(1).connect(connected_graph.Nodes.get(2));
        connected_graph.Nodes.get(4).connect(connected_graph.Nodes.get(5));
        connected_graph.Nodes.get(4).connect(connected_graph.Nodes.get(2));
        connected_graph.Nodes.get(5).connect(connected_graph.Nodes.get(1));


        /*int minConnectedTo = 0;
        for (Node aNode: connected_graph.Nodes) {
            if (aNode.connectedTo != null && aNode.connectedTo.size() > 0)
                continue;
            if (minConnectedTo < max_nodes-2) {
                aNode.connect(connected_graph.Nodes.get(minConnectedTo + 2));
            }
            int nodeI = rn.nextInt(max_nodes);
            for (int i = 0; i < 1; i++) {
                aNode.connect(connected_graph.Nodes.get(nodeI));
            }
        }*/
        Tree.Print(connected_graph.Nodes, max_nodes, max_nodes);

        List<Node> tree = min_spanning_tree.Get(connected_graph);

        System.out.println("Tree length: " + tree.size());
        System.out.println("--------------------------");
        Tree.Print(tree, max_nodes, max_nodes);
    }
}
