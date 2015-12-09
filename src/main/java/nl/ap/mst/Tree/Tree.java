package nl.ap.mst.Tree;

import nl.ap.mst.Graph.Node;

import java.util.ArrayList;
import java.util.List;

public class Tree {

    List<TreeNode> nodes;

    public Tree() {
        nodes = new ArrayList<>();
    }

    public void Add(TreeNode node) {
        if (Has(node))
            return;

        nodes.add(node);
    }

    public boolean Has(TreeNode aNode) {
        for (TreeNode node : nodes) {
            if (node.x == aNode.x && node.y == aNode.y)
                return true;
        }
        return false;
    }

    public void Connect(TreeNode aNode, TreeNode to) {
        Add(aNode);
        Add(to);

        aNode.connectedTo.add(to);
        to.connectedTo.add(aNode);
    }

    public int size() {
        return 0;
    }

    public static void Print(Tree tree, int maxX, int maxY) {
        int currentLine = 0;
        int nodeN = 0;
        for (int x = 0; x < maxX; x++) {
            for (int y = 0; y < maxY; y++) {
                boolean found = false;
                TreeNode foundNode = null;
                int foundNodeIndex = 0;
                for (TreeNode aNode : tree.nodes) {
                    if (aNode.x == x && aNode.y == y) {
                        found = true;
                        foundNode = aNode;
                        break;
                    }
                    foundNodeIndex++;
                }
                if (found) {
                    String connectedNodeText = "";
                    for (TreeNode aNode : foundNode.connectedTo) {
                        for (TreeNode anotherNode : tree.nodes) {
                            if (anotherNode.x == aNode.x && anotherNode.y == aNode.y) {
                                connectedNodeText+= "," + anotherNode.value;
                                connectedNodeText+= "{" + (int)foundNode.DistanceTo(anotherNode) + "}";
                                break;
                            }
                        }
                    }

                    System.out.print("[" + foundNode.x +"|"+foundNode.y + "(" + foundNode.value + ")"+connectedNodeText+"]");
                } else {
                    System.out.print("            ");
                }
            }
            System.out.print("\n\n");
        }

    }


    public static void Print(List<Node> nodes, int maxX, int maxY) {
        int currentLine = 0;
        int nodeN = 0;
        for (int x = 0; x < maxX; x++) {
            for (int y = 0; y < maxY; y++) {
                boolean found = false;
                Node foundNode = null;
                int foundNodeIndex = 0;
                for (Node aNode : nodes) {
                    if (aNode.x == x && aNode.y == y) {
                        found = true;
                        foundNode = aNode;
                        break;
                    }
                    foundNodeIndex++;
                }
                if (found) {
                    String connectedNodeText = "";
                    for (Node aNode : foundNode.connectedTo) {
                        for (Node anotherNode : nodes) {
                            if (anotherNode.x == aNode.x && anotherNode.y == aNode.y) {
                                connectedNodeText+= "," + anotherNode.value;
                                connectedNodeText+= "{" + (int)foundNode.DistanceTo(anotherNode) + "}";
                                break;
                            }
                        }
                    }

                    System.out.print("[" + foundNode.x +"|"+foundNode.y + "(" + foundNode.value + ")"+connectedNodeText+"]");
                } else {
                    System.out.print("            ");
                }
            }
            System.out.print("\n\n");
        }

    }
}
