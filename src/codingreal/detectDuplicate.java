package codingreal;

public class detectDuplicate {
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int data) {
            this.data = data;
        }

        TreeNode(int data, TreeNode left, TreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    public static String computeBinary(int val){
        StringBuilder sb = new StringBuilder();
        int reversed = 0;
        while(val > 1){
            int remainder = val % 2;
            reversed = reversed * 10 + remainder;
            val /= 2;
        }
        return sb.append(reversed).toString();
    }
    public static void main(String[] args){
        detectDuplicate tree = new detectDuplicate();
        TreeNode first = new TreeNode(5);
        TreeNode second = new TreeNode(7);
        TreeNode third = new TreeNode(9);
        TreeNode fourth = new TreeNode(10);
        TreeNode fifth = new TreeNode(11);

        first.left = second;
        first.right = third;
        first.left.left = fourth;
        first.right.left = fifth;

    }
}
