package nl.ap.mst;

import nl.ap.mst.Graph.Graph;
import nl.ap.mst.Graph.Node;
import nl.ap.mst.Tree.Tree;

import java.util.List;

public class MST {

    Tree Get(Graph graph) {
        Node start = CalculateStartingNode(graph);



        return null;
    }


    Node CalculateStartingNode(Graph aGraph) {
        Node startingNode = null;
        double closestDistance = 0;

        for(Node aNode : aGraph.Nodes) {
            if (startingNode == null) {
                startingNode = aNode;
                closestDistance = aNode.GetClosestNeighbour().DistanceTo(aNode);
            } else { // TODO we are assuming all nodes have atleast one connection
                double distanceToNeighbour = aNode.GetClosestNeighbour().DistanceTo(aNode);
                if (distanceToNeighbour < closestDistance) {
                    closestDistance = distanceToNeighbour;
                    startingNode = aNode;
                }
            }
        }
        return startingNode;
    }
}
