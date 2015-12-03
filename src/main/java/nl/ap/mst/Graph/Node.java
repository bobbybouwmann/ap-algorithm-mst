package nl.ap.mst.Graph;

import java.util.List;

public class Node {
    public int x;
    public int y;

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
}
