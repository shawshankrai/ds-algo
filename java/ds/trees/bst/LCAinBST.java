package ds.trees.bst;

import ds.trees.TreeNode;

public class LCAinBST {
    private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode current = root;
        
        while(current != null) {
            if(p.val < current.val && q.val < current.val) {
                current = current.left;
            } else if (p.val > current.val && q.val > current.val) {
                current = current.right;
            } else {
                return current;
            }
        }

        return null;
    }
    public static void main(String[] args) {
        /*
                  10
                /    \
              5      12
            /   \   /  \
          4     6 11  13
        */
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(11);
        root.right.right = new TreeNode(13);

        TreeNode p = root.left.left;   // 4
        TreeNode q = root.left.right;  // 6
        System.out.println(lowestCommonAncestor(root, p, q).val); // 5

        p = root.right.left;  // 11
        q = root.right.right; // 13
        System.out.println(lowestCommonAncestor(root, p, q).val); // 12

        p = root.left;  // 5
        q = root.right; // 12
        System.out.println(lowestCommonAncestor(root, p, q).val); // 10
    }
}
