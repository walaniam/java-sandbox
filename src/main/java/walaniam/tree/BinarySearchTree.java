package walaniam.tree;

public class BinarySearchTree {

    public static void main(String[] args) {

        final Node root = new Node(8, null);

        root.insert(13);
        root.insert(14);
        root.insert(10);
        root.insert(7);
        root.insert(6);
        root.insert(5);
        root.insert(4);
        root.insert(3);
        root.insert(11);

        root.printTree();
    }


}
