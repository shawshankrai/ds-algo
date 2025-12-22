package ds.trees;

public class DiameterOfBinaryTree {

    // Return both height and diameter explicitly (no hidden update)
    static class Result {
        int height;   // height in edges
        int diameter; // diameter in edges

        Result(int height, int diameter) {
            this.height = height;
            this.diameter = diameter;
        }
    }

    public static int diameterOfBinaryTree(TreeNode root) {
        return dfs(root).diameter;
    }

    private static Result dfs(TreeNode node) {
        if(node == null) return new Result(-1, 0);
        
        Result left = dfs(node.left);
        Result right = dfs(node.right);

        int height = Math.max(left.height, right.height) + 1;
        int diameterThroughNode = left.height + right.height + 2;

        int diameter = Math.max(Math.max(left.diameter, right.diameter), diameterThroughNode);
        
        return new Result(height, diameter);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(diameterOfBinaryTree(root)); // expected: 3
    }
}