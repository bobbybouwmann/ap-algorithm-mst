package nl.ap.mst;

import nl.ap.mst.Graph.Graph;
import nl.ap.mst.Graph.Node;
import nl.ap.mst.Tree.Tree;
import nl.ap.mst.Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class MST {
    List<Node> walkedPath;

    public Tree Get(Graph graph) {
        walkedPath = new ArrayList<>();
        Node start = graph.Nodes.size() > 0 ? graph.Nodes.get(0) : null;
        if (start == null)
            return null; // no vertices with edges found in our graph

        // our connections
        Tree ourTree = new Tree();
        ourTree.Add(TreeNode.Create(start));
        walkedPath.add(start); // Our starting point

        while (walkedPath.size() != graph.Nodes.size()) {
            FindNextNode(walkedPath, ourTree);
        }

        return ourTree;
    }

    void FindNextNode(List<Node> nodes, Tree ourTree) {
        Node startingNode = null;
        Node closestNode = null;
        double closestDistance = -1;

        for(Node aNode : nodes) {
            if (startingNode == null) {
                Node closestToUs = GetClosestAvailableNode(aNode);
                if (closestToUs == null)
                    continue;
                closestDistance = closestToUs.DistanceTo(aNode);
                closestNode = closestToUs;
                startingNode = aNode;
            } else { // We are assuming all nodes have at least one connection -> connected graph
                Node closestToUs = GetClosestAvailableNode(aNode);
                if (closestToUs == null)
                    continue;
                double distanceToNeighbour = closestToUs.DistanceTo(aNode);
                if (distanceToNeighbour < closestDistance) {
                    closestDistance = distanceToNeighbour;
                    startingNode = aNode;
                    closestNode = closestToUs;
                }
            }
        }
        if (startingNode == null || closestNode == null)
            return;
        walkedPath.add(closestNode); // the new node should be added to our walked path
        ourTree.Connect(TreeNode.Create(closestNode), TreeNode.Create(startingNode));
    }

    Node GetClosestAvailableNode(Node from) {
        Node nearest = null;
        double closestDistance = -1;

        for(Node aNode : from.connectedTo) {
            if (AlreadyUsed(aNode)) // only walk our non used nodes
                continue;

            if (nearest == null) { // no closest found yet - So the first we encounter is our closest node
                nearest = aNode;
                closestDistance = aNode.DistanceTo(aNode); // store the distance to our first encountered node for comparing later
            } else { // TODO we are assuming all nodes have at least one connection
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
