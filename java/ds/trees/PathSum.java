package ds.trees;

public class PathSum {
    private static boolean hasPathSum(TreeNode root, int target) {
        if(root == null) return false;

        if(root.left == null && root.right == null) {
            return target == root.val;
        }

        int remaining = target - root.val;

        return hasPathSum(root.left, remaining) || hasPathSum(root.right, remaining);
    }
    public static void main(String[] args) {
        /*
                5
               / \
              4   8
             /   / \
            11  13  4
           /  \
          7    2

          targetSum = 22
          Path: 5 → 4 → 11 → 2
        */

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);

        System.out.println(hasPathSum(root, 22)); // true
    }
}
