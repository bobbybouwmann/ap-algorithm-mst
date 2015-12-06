package nl.ap.mst;

import nl.ap.mst.Graph.Graph;
import nl.ap.mst.Graph.Node;
import nl.ap.mst.Tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class MST {
    List<Node> walkedPath;

    List<Node> Get(Graph graph) {
        walkedPath = new ArrayList<>();

        // our connections
        List<Node> ourTree = new ArrayList<>();
        Node aNode = FindNodeWithClosestConnection(graph);

        while (aNode != null) {
            walkedPath.add(aNode);
            Node closestToUs = GetClosestAvailableNode(aNode); // everything should have at least one connection that is closest to us
            ourTree.add(aNode.CopyForTree(closestToUs.CopyForTree()));

            aNode = FindNodeWithClosestConnection(graph); // find the next item
        }

        return ourTree;
    }

    Node FindNodeWithClosestConnection(Graph aGraph) {
        Node startingNode = null;
        double closestDistance = 0;

        List<Node> evaluatedNodes = new ArrayList<>();

        for(Node aNode : aGraph.Nodes) {
            if (AlreadyUsed(aNode) || evaluatedNodes.contains((aNode))) // only walk our non used nodes
                continue;

            if (startingNode == null) {
                startingNode = aNode;
                Node closestToUs = GetClosestAvailableNode(aNode);
                closestDistance = closestToUs.DistanceTo(aNode);
            } else { // We are assuming all nodes have at least one connection -> connected graph
                Node closestToUs = GetClosestAvailableNode(aNode);
                double distanceToNeighbour = closestToUs.DistanceTo(aNode);
                if (distanceToNeighbour < closestDistance) {
                    closestDistance = distanceToNeighbour;
                    startingNode = aNode;
                }
            }
            evaluatedNodes.add(aNode);
        }
        return startingNode;
    }

    Node GetClosestAvailableNode(Node from) {
        Node nearest = null;
        double closestDistance = 0;

        for(Node aNode : from.connectedTo) {
            if (nearest == null) { // no closest found yet - So the first we encounter is our closest node
                nearest = aNode;
                closestDistance = aNode.DistanceTo(aNode); // store the distance to our first encountered node for comparing later
            } else { // TODO we are assuming all nodes have atleast one connection
                double distanceToNeighbour = aNode.DistanceTo(aNode);
                if (distanceToNeighbour < closestDistance) { // Check if this neighbour node is closer as our already found node
                    closestDistance = distanceToNeighbour;
                    nearest = aNode;
                }
            }
        }
        return nearest;
    }

    boolean AlreadyUsed(Node aNode) {
        return walkedPath.contains(aNode);
    }
}
