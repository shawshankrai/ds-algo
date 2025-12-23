package ds.trees;

public class BinaryTreeMaximumPathSum {
    private static int maxValue;

    private static int maxPathSum(TreeNode root) {
        maxValue = Integer.MIN_VALUE;
        dfs(root);
        return maxValue;
    }

    private static int dfs(TreeNode root) {
        if(root == null) return 0;

        int leftGain = Math.max(0, dfs(root.left));
        int rightGain = Math.max(0, dfs(root.right));

        int pathThroughNode = root.val + leftGain + rightGain;
        maxValue = Math.max(maxValue, pathThroughNode);

        return root.val + Math.max(leftGain, rightGain);
    }

    public static void main(String[] args) {
        /*
                -10
                /  \
               9   20
                  /  \
                 15   7

            Maximum path sum = 42 (15 → 20 → 7)
        */

        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(maxPathSum(root)); // 42
    }
}
