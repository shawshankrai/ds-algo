package ds.trees.bst;

import java.util.Stack;

import ds.trees.TreeNode;

public class kthLargestIter {
    private static int findKthLargest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while(current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.right;
            }

            current = stack.pop();
            k--;
            if(k == 0) return current.val;

            current = current.left;
        }

        return -1;
    }
    public static void main(String[] args) {
        TreeNode rootToo = new TreeNode(10);
        rootToo.left = new TreeNode(5);
        rootToo.right = new TreeNode(12);

        rootToo.left.left = new TreeNode(4);
        rootToo.left.right = new TreeNode(6);

        rootToo.right.left = new TreeNode(11);
        rootToo.right.right = new TreeNode(13);

        System.out.println(findKthLargest(rootToo, 4));
    }
}
