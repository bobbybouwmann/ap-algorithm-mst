package nl.ap.mst.Graph;

import java.util.ArrayList;
import java.util.List;

public class Node {
    public int x;
    public int y;
    public int value;

    public List<Node> connectedTo;

    public Node GetClosestNeighbour() {
        Node closest = null;

        for (Node aNode : connectedTo) {
            if (closest == null) {
                closest = aNode;
            } else {
                if (DistanceTo(aNode) < DistanceTo(closest)) {
                    closest = aNode;
                }
            }
        }
        return closest;
    }

    public double DistanceTo(Node aNode) {
        int diffX = Math.abs(aNode.x - this.x);
        int diffY = Math.abs(aNode.y - this.y);

        return Math.abs(Math.sqrt(diffX * diffX + diffY * diffY));
    }


    public Node CopyForTree() {
        Node newNode = new Node();
        newNode.x = this.x;
        newNode.y = this.y;
        newNode.value = this.value;
        return newNode;
    }

    public Node CopyForTree(Node connection) {
        Node newNode = new Node();
        newNode.x = this.x;
        newNode.y = this.y;
        newNode.value = this.value;
        newNode.connectedTo = new ArrayList<>();
        newNode.connectedTo.add(connection);

        if (connection.connectedTo == null)
            connection.connectedTo = new ArrayList<>();
        connection.connectedTo.add(newNode);

        return newNode;
    }
    public void connect(Node aNode) {
        if (this.connectedTo == null)
            this.connectedTo = new ArrayList<>();
        if (!this.connectedTo.contains(aNode))
            this.connectedTo.add(aNode);

        if (aNode.connectedTo == null)
            aNode.connectedTo = new ArrayList<>();
        if (!aNode.connectedTo.contains(this))
            aNode.connectedTo.add(this);
    }
}
