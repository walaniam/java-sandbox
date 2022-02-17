package walaniam.tree;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@ToString(of = "value")
public class Node implements Comparable<Node> {

    final Integer value;
    final Node parent;
    Node left;
    Node right;

    public void insert(int value) {
        insertAt(this, value);
    }

    private void insertAt(Node node, int value) {
        if (value < node.value) {
            if (node.left == null) {
                node.left = new Node(value, node);
            } else {
                insertAt(node.left, value);
            }
        } else if (value > node.value) {
            if (node.right == null) {
                node.right = new Node(value, node);
            } else {
                insertAt(node.right, value);
            }
        }
    }

    public void printTree() {
        BTreePrinter.printNode(this);
    }

    @Override
    public int compareTo(Node o) {
        return this.value.compareTo(o.value);
    }
}
