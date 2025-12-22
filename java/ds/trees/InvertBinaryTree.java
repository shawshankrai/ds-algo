package ds.trees;

public class InvertBinaryTree {

    private static TreeNode invertTree(TreeNode root) {
        if(root == null) return null;

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }
    
    private static void preOrder(TreeNode root) {
        if(root == null) return;

        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void main(String[] args) {
        /*
                Original tree:
                    1
                   / \
                  2   3
                 / \
                4   5

                Inverted tree:
                     1
                    / \
                    3   2
                        / \
                        5   4
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        // Invert the tree
        invertTree(root);

        // Verify using preorder traversal
        // Expected output: 1 3 2 5 4
        preOrder(root);
    }
    
}
