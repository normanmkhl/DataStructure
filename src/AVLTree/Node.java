package AVLTree;

public class Node {
    public int value;
    public int balance;
    public int height;
    public Node left, right, parent;

    Node(int value, Node parent) {
        this.value = value;
        this.parent = parent;
    }
}
