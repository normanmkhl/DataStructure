/**
 * @author Norman Mikhail
 */
package AVLTree;

public class AVLTree {

    Node root;

    public boolean insert(int value) {
        //check if root is null or not; if not make the new node the root
        if (root == null)
            root = new Node(value, null);
        //insert the nodes into the tree then update the balance
        else {
            Node n = root;
            Node parent;
            //traverse through the tree to find the appropriate location for the node
            while (true) {
                if (n.value == value)
                    return false;

                parent = n;

                boolean goLeft = n.value > value;
                n = goLeft ? n.left : n.right;

                if (n == null) {
                    if (goLeft) {
                        parent.left = new Node(value, parent);
                    } else {
                        parent.right = new Node(value, parent);
                    }
                    rebalance(parent);
                    break;
                }
            }
        }
        return true;
    }

    private void delete(Node node) {
        //check if the children are null; if not update the references of the node to null
        if (node.left == null && node.right == null) {
            if (node.parent == null) root = null;
            else {
                Node parent = node.parent;
                if (parent.left == node) {
                    parent.left = null;
                } else parent.right = null;
                rebalance(parent);
            }
            return;
        }
        //reference the nodes children
        if (node.left != null) {
            Node child = node.left;
            while (child.right != null) child = child.right;
            node.value = child.value;
            delete(child);
        } else {
            Node child = node.right;
            while (child.left != null) child = child.left;
            node.value = child.value;
            delete(child);
        }
    }

    public void delete(int delKey) {
        //check if root is null or not; if not make the node as the root
        if (root == null)
            return;
        Node node = root;
        Node child = root;
        //traverse through the tree to find the nodes that wanted to be deleted
        while (child != null) {
            node = child;
            child = delKey >= node.value ? node.right : node.left;
            if (delKey == node.value) {
                delete(node);
                return;
            }
        }
    }

    private void rebalance(Node n) {
        //set the balance
        setBalance(n);
        //check if the tree is unbalanced or not; if unbalanced use rotation
        if (n.balance == -2) {
            if (height(n.left.left) >= height(n.left.right))
                n = rotateRight(n);
            else
                n = rotateLeftThenRight(n);

        } else if (n.balance == 2) {
            if (height(n.right.right) >= height(n.right.left))
                n = rotateLeft(n);
            else
                n = rotateRightThenLeft(n);
        }

        if (n.parent != null) {
            rebalance(n.parent);
        } else {
            root = n;
        }
    }

    // set the root node 'a' value
    private Node rotateLeft(Node a) {
        //assign b to the right child of a and set parent of b to parent of a
        Node b = a.right;
        b.parent = a.parent;
        //point the right child of a to b left child
        a.right = b.left;
        /*check if right child of a is not null if not null then assign right child
        parent of a to a
         */
        if (a.right != null)
            a.right.parent = a;
        //point left subtree of b to a; point parent of a to b
        b.left = a;
        a.parent = b;

        /* check if parent of b is not null if not null then assign right parent
        of b to b; if null then assign left parent of b to b
         */
        if (b.parent != null) {
            if (b.parent.right == a) {
                b.parent.right = b;
            } else {
                b.parent.left = b;
            }
        }
        //set the balance
        setBalance(a, b);

        return b;
    }

    //set the root node 'a' value
    private Node rotateRight(Node a) {
        //assign b to the left child of a and set parent of b to parent of a
        Node b = a.left;
        b.parent = a.parent;

        //point the left child of a to b right child
        a.left = b.right;

         /*check if left child of a is not null if not null then assign left child
        parent of a to a
         */
        if (a.left != null)
            a.left.parent = a;

        //point left subtree of b to a; point parent of a to b
        b.right = a;
        a.parent = b;

        /* check if parent of b is not null if not null then assign right parent
        of b to b; if null then assign left parent of b to b
         */
        if (b.parent != null) {
            if (b.parent.right == a) {
                b.parent.right = b;
            } else {
                b.parent.left = b;
            }
        }
        //set the balance
        setBalance(a, b);

        return b;
    }

    private Node rotateLeftThenRight(Node n) {
        n.left = rotateLeft(n.left);
        return rotateRight(n);
    }

    private Node rotateRightThenLeft(Node n) {
        n.right = rotateRight(n.right);
        return rotateLeft(n);
    }

    private int height(Node n) {
        if (n == null)
            return -1;
        return n.height;
    }

    /**
     * Get the height of the tree and increment it by 1 to get the actual height.
     * Get it by taking the greater value between the height of the left and right subtree
     * and add one to that value.
     * Null pointers return a height of zero, because -1 + 1 = 0.
     * */
    private void reHeight(Node node) {
        if (node != null) {
            node.height = 1 + Math.max(height(node.left), height(node.right));
        }
    }

    //function to take all nodes, update the height, then set the balance
    private void setBalance(Node... nodes) {
        for (Node n : nodes) {
            reHeight(n);
            n.balance = height(n.right) - height(n.left);
        }
    }

    public void printBalance() {
        printBalance(root);
    }

    private void printBalance(Node n) {
        if (n != null) {
            printBalance(n.left);
            System.out.printf("%s ", n.balance);
            printBalance(n.right);
        }
    }

    public void PreOrder(){
        PreOrder(root);
    }

    public void PreOrder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.value + "--> ");
        PreOrder(root.left);
        PreOrder(root.right);
    }

    public void InOrder(){
        InOrder(root);
    }

    public void InOrder(Node root){
        if(root == null){
            return;
        }
        InOrder(root.left);
        System.out.print(root.value + "--> ");
        InOrder(root.right);
    }

    public void PostOrder(){
        PostOrder(root);
    }

    public void PostOrder(Node root){
        if(root == null){
            return;
        }
        PostOrder(root.left);
        PostOrder(root.right);
        System.out.print(root.value + "--> ");
    }

    public Node Search(int key){
        return Search(root,key);
    }

    public Node Search(Node root,int key){
        if(root == null || root.value == key){
            return root;
        }
        if(key < root.value){
            return Search(root.left,key);
        }else{
            return Search(root.right,key);
        }
    }

    public void BTsmallest(){
        BTsmallest(root);
    }

    public void BTsmallest(Node root){
        if(root == null){
            return;
        }
        if(root.left == null){
            System.out.println(root.value);
        }
        BTsmallest(root.left);
    }

    public void BTbiggest(){
        BTbiggest(root);
    }

    public void BTbiggest(Node root){
        if(root == null){
            return;
        }
        if(root.right == null){
            System.out.println(root.value);
        }
        BTbiggest(root.right);
    }
}
