package ds.trees.bst;

import ds.trees.TreeNode;

public class SearchBST {

    private static TreeNode searchBST(TreeNode root, int target) {
        if(root == null) return root;

        if(root.val == target) return root;

        if(root.val > target) return searchBST(root.left, target); 
        else return searchBST(root.right, target);
    }

    private static TreeNode searchBSTIter(TreeNode root, int target) {
        TreeNode current = root;
        while(current != null) {
            if(current.val == target) return current;
            else if(current.val > target) current = current.left; 
            else current = current.right;
        }

        return current;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(20);

        System.out.println(searchBST(root, 12));
        System.out.println(searchBSTIter(root, 12));
    }
}
