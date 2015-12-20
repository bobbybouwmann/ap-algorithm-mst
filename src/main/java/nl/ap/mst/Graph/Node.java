package nl.ap.mst.Graph;

import java.util.ArrayList;
import java.util.List;

public class Node {
    public int x;
    public int y;
    public int value;

    public List<Node> connectedTo; // our edges
    public List<Node> lowestConn; // what edges this node is connected to in our minimum

    public Node() {
        connectedTo = new ArrayList<>();
        lowestConn = new ArrayList<>();
    }

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
        //if (!connectedTo.contains(aNode))
       //     return 999999999;

        int diffX = Math.abs(aNode.x - this.x);
        int diffY = Math.abs(aNode.y - this.y);

        return Math.abs(Math.sqrt(diffX * diffX + diffY * diffY));
    }

    public void connect(Node aNode) {
        if (this == aNode)
            return;

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
