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
}
