package BinaryTree;

import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
    TreeNode root;

    class TreeNode{
        public TreeNode left;
        public TreeNode right;
        public int data;

    public TreeNode(int data){
    this.data = data;
        }
    }

    public void createBinaryTree(){
        TreeNode first = new TreeNode(9);
        TreeNode second = new TreeNode(2);
        TreeNode third = new TreeNode(3);
        TreeNode fourth = new TreeNode(4);
        TreeNode fifth = new TreeNode(10);
        TreeNode sixth = new TreeNode(8);
        TreeNode seventh = new TreeNode(11);

        root = first;
        first.left = second;
        first.right = third;

        second.left = fourth;
        second.right = fifth;

        third.left = sixth;
        third.right = seventh;

    }
    public void recPreOrder(TreeNode root){
        if(root == null){
            return;
        }
        System.out.println(root.data);
        recPreOrder(root.left);
        recPreOrder(root.right);
    }

    public void iterPreOrder(){
        if(root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();
            System.out.println(temp.data);
            if(temp.right != null){
                stack.push(temp.right);
            }
            if(temp.left != null){
                stack.push(temp.left);
            }
        }
    }
    public void recInOrder(TreeNode root){
        if(root == null){
            return;
        }
        recInOrder(root.left);
        System.out.println(root.data);
        recInOrder(root.right);
    }
    public void iterInOrder(){
        if(root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack();
        TreeNode temp = root;
        while(!stack.isEmpty() || temp != null) {
            if (temp != null) {
                stack.push(temp);
                temp = temp.left;
            } else {
                temp = stack.pop();
                System.out.println(temp.data);
                temp = temp.right;
            }
        }
    }
    public void recPostOrder(TreeNode root){
        if(root == null){
            return;
        }
        recPostOrder(root.left);
        recPostOrder(root.right);
        System.out.println(root.data);
    }
    public void levelOrder(TreeNode root){
        if (root == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();
            System.out.println(temp.data);
            if(root.left != null){
                queue.offer(root.left);
            }
            if(root.right != null){
                queue.offer(root.right);
            }
        }
    }

    // ALL FUNCTION FOR BINARY SEARCH TREE ( BST )


    public TreeNode binarySearchTreeInsert(TreeNode root, int value){
        if(root == null){
            root = new TreeNode(value);
            return root;
        }
        if(value < root.data){
            root.left = binarySearchTreeInsert(root.left, value);
        }else{
            root.right = binarySearchTreeInsert(root.left, value);
        }
        return root;
    }

    public void BSTInOrder(){
        BSTInOrder(root);
    }

    public void BSTInOrder(TreeNode root){
        if(root == null){
            return;
        }
        BSTInOrder(root.left);
        System.out.println(root.data);
        BSTInOrder(root.right);
    }

    public TreeNode SearchBST(TreeNode root,int key){
        if(root.data == key || root == null){
            return root;
        }else if(key < root.data){
            return SearchBST(root.left,key);
        }else{
            return SearchBST(root.right,key);
        }
    }

    public static void main(String[] args){
        BinaryTree bt = new BinaryTree();
        bt.createBinaryTree();
        bt.iterInOrder();

    }
}