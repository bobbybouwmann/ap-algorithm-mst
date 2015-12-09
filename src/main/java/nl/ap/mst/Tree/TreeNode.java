package nl.ap.mst.Tree;

import nl.ap.mst.Graph.Node;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    public int x;
    public int y;
    public int value;

    public List<TreeNode> connectedTo; // our edges

    public TreeNode() {
        connectedTo = new ArrayList<>();
    }

    public static TreeNode Create(Node aNode) {
        TreeNode node = new TreeNode();
        node.x = aNode.x;
        node.y = aNode.y;
        node.value = aNode.value;

        return node;
    }

    public double DistanceTo(TreeNode aNode) {
        //if (!connectedTo.contains(aNode) && !aNode.connectedTo.contains(this))
        //    return 999999999;

        int diffX = Math.abs(aNode.x - this.x);
        int diffY = Math.abs(aNode.y - this.y);

        return Math.abs(Math.sqrt(diffX * diffX + diffY * diffY));
    }
}
