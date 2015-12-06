package nl.ap.mst.Graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    public List<Node> Nodes;

    public Graph() {
        Nodes = new ArrayList<>();
    }

    public void Print() {
        for (Node aNode: Nodes) {
            System.out.println(aNode.value);
        }
    }
}
