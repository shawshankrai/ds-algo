package ds.trees.bst;

import ds.trees.TreeNode;

public class ValidateBST {
    private static boolean validate(TreeNode node, long min, long max) {
        if(node == null) return true;

        if(node.val <= min || node.val >= max) return false;

        return validate(node.left, min, node.val) && 
               validate(node.right, node.val, max);
    }
    private static boolean isValidBST(TreeNode node) {
        return validate(node, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public static void main(String[] args) {
        /*
                Valid BST:
                    10
                   /  \
                  5    15
                      /  \
                     12   20
        */
        TreeNode a = new TreeNode(10);
        a.left = new TreeNode(5);
        a.right = new TreeNode(15);
        a.right.left = new TreeNode(12);
        a.right.right = new TreeNode(20);

        System.out.println(isValidBST(a)); // true

        /*
                Invalid BST (classic trap):
                    10
                   /  \
                  5    15
                      /
                     6   (6 is < 10, violates ancestor constraint)
        */
        TreeNode b = new TreeNode(10);
        b.left = new TreeNode(5);
        b.right = new TreeNode(15);
        b.right.left = new TreeNode(6);

        System.out.println(isValidBST(b)); // false

        /*
                Edge case:
                Single node is always valid
        */
        TreeNode c = new TreeNode(1);
        System.out.println(isValidBST(c)); // true
    }
}
