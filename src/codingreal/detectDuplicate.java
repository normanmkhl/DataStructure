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
    public static String insertStar(String s){
        if(s == null || s == "" || s.length() == 1){
            return s;
        }
        int count = 1;
        for(int i = 0; i < s.length();i++){
            for(int j = i+1; j < s.length();j++){
                if(s.charAt(i) == s.charAt(j)) {
                    s = s.charAt(i) + "*";
                }
                while(count != 0){
                    s = s + s.charAt(j);
                    count--;
                }
            }
        }
        return s;
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
