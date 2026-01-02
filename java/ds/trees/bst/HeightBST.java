package ds.trees.bst;

import ds.trees.TreeNode;

public class HeightBST {

    private static int height(TreeNode node) {
        if(node == null) return -1;

        return 1 + Math.max(height(node.left), height(node.right));
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

        System.out.println(height(root));
    }
}
