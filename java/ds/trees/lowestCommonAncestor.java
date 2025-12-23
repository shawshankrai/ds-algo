package ds.trees;

public class lowestCommonAncestor {
    // Each call returns the node if it contains p or q (or the LCA if it contains both); 
    // the first node where left and right both return non-null is the LCA.
    private static TreeNode lowestCommonAncestorNode(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;

        TreeNode left = lowestCommonAncestorNode(root.left, p, q);
        TreeNode right = lowestCommonAncestorNode(root.right, p, q);


        if(left != null && right != null) {
            return root;
        }

        return left != null ? left : right;
    }
    public static void main(String[] args) {
        /*
                3
               / \
              5   1
             / \ / \
            6  2 0  8
              / \
             7   4

            LCA of 5 and 1 = 3
            LCA of 5 and 4 = 5
        */

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        System.out.println(lowestCommonAncestorNode(root, root.left, root.right).val); // 3
        System.out.println(lowestCommonAncestorNode(root, root.left, root.left.right.right).val); // 5
        System.out.println(lowestCommonAncestorNode(root, root.left, root.right.left).val); // 3

    }
}
