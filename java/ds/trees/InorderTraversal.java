package ds.trees;

public class InorderTraversal {
    private static void inOrder(TreeNode root) {
        if(root == null) return;
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }
    public static void main(String[] args) {
        /*
                1
               / \
              2   3
             / \
            4   5

            Expected inorder output:
            4 2 5 1 3
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        inOrder(root);
    }
}
