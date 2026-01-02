package ds.trees.bst;

import ds.trees.TreeNode;

public class InsertBST {

    private static TreeNode insertIntoBSTIter(TreeNode root, int valToInsert) {
        if(root == null) return new TreeNode(valToInsert);
        TreeNode current = root;

        while (true) {
            if(current.val > valToInsert) {
                if(current.left == null) {
                    current.left = new TreeNode(valToInsert);
                    break;
                }
                current = current.left;
            }
            else {
                if(current.right == null) {
                    current.right = new TreeNode(valToInsert);
                    break;
                }
                current = current.right;
            }
        }

        return root;
    }

    private static TreeNode insertIntoBST(TreeNode root, int valToInsert) {
        if(root == null) return new TreeNode(valToInsert);

        if(valToInsert < root.val) 
            root.left =  insertIntoBST(root.left, valToInsert);
        else 
            root.right = insertIntoBST(root.right, valToInsert);

        return root;
    }

    private static void inOrder(TreeNode root) {
        if(root == null) return;

        inOrder(root.left);
        System.out.print(root.val + " ");
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

        int valToInsert = 9;

        // root = insertIntoBST(root, valToInsert);
        root = insertIntoBSTIter(root, valToInsert);

        // You can verify by inOrder traversal (should be sorted)
        inOrder(root);
    }
    
}
