package ds.trees;

public class PostorderTraversal {
    private static void postorder(TreeNode root) {
        if(root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.val + " ");
    }
    public static void main(String[] args) {
        /*
                1
               / \
              2   3
             / \
            4   5

            Expected postorder output:
            4 5 2 3 1
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        postorder(root);
    }
}
