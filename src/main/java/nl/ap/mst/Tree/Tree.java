package nl.ap.mst.Tree;

import nl.ap.mst.Graph.Node;

import java.util.List;

public class Tree {

    public static void Print(List<Node> treeNodes, int maxX, int maxY) {
        int currentLine = 0;
        int nodeN = 0;
        for (int x = 0; x < maxX; x++) {
            for (int y = 0; y < maxY; y++) {
                boolean found = false;
                Node foundNode = null;
                int foundNodeIndex = 0;
                for (Node aNode : treeNodes) {
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
                        for (Node anotherNode : treeNodes) {
                            if (anotherNode.x == aNode.x && anotherNode.y == aNode.y) {
                                connectedNodeText+= "," + anotherNode.value;
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
