package ds.trees.bst;

import ds.trees.TreeNode;

public class KSmallest {
    static TreeNode answer = null;
    static int kInput = 0;

    private static TreeNode findKSmallest(TreeNode root, int k) {
        kInput = k;
        inOrder(root);
        return answer;
    }

    private static void inOrder(TreeNode root) {
        if(root == null || answer != null) return;

        inOrder(root.left);

        kInput --;
        if(kInput == 0) {
            answer = root;
            return;
        }

        inOrder(root.right);
    }
    public static void main(String[] args) {
        TreeNode rootToo = new TreeNode(10);
        rootToo.left = new TreeNode(5);
        rootToo.right = new TreeNode(12);

        rootToo.left.left = new TreeNode(4);
        rootToo.left.right = new TreeNode(6);

        rootToo.right.left = new TreeNode(11);
        rootToo.right.right = new TreeNode(13);

        System.out.println(findKSmallest(rootToo, 4));
    }
}
