package ds.trees;

public class MaxDepthOfBinaryTree {
    private static int maxDepth(TreeNode root) {
        if(root == null) return 0;

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }
    public static void main(String[] args) {
        /*
                1
               / \
              2   3
             / \
            4   5

            Max depth = 3
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(maxDepth(root)); // 3
    }
}
