package ds.trees.bst;

import ds.trees.TreeNode;

public class DeleteBST {

    private static TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;

        if(key < root.val) root.left = deleteNode(root.left, key);
        else if(key > root.val) root.right = deleteNode(root.right, key);
        else {
            if(root.right == null) return root.left;
            if(root.left == null) return root.right;

            int successorNode = minValue(root.right);
            root.val = successorNode;
            root.right =  deleteNode(root.right, successorNode);
        }

        return root;
    }

    private static int minValue(TreeNode node) {
        while(node.left != null) node = node.left;
        return node.val;
    }

    private static void inOrder(TreeNode root) {
        if(root == null) return;
        inOrder(root.left);
        System.out.println(root.val);
        inOrder(root.right);
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

        System.out.print("Original inorder: ");
        inOrder(root);
        System.out.println();

        int key = 12; // try deleting: 4 (leaf), 5 (two children), 11 (leaf), 12 (two children)
        root = deleteNode(root, key);

        System.out.print("After deleting " + key + ": ");
        inOrder(root);
        System.out.println();
    }
}