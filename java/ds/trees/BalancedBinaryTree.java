package ds.trees;

public class BalancedBinaryTree {
    private static boolean isBalanced(TreeNode root) {
        return heightOfTree(root) != -1;
    }

    private static int heightOfTree(TreeNode root) {
        if(root == null) return 0;

        int leftHeight = heightOfTree(root.left);
        if(leftHeight == -1) return -1;

        int rightHeight = heightOfTree(root.right);
        if(rightHeight == -1) return -1;

        if(Math.abs(leftHeight - rightHeight) > 1) return -1;

        int height = Math.max(leftHeight, rightHeight) + 1;

        return height;
    }
    public static void main(String[] args) {
        /*
                1
               / \
              2   3
             /
            4
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);

        System.out.println(isBalanced(root)); // true
    }
}
