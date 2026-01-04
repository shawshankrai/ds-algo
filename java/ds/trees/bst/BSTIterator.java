package ds.trees.bst;

import java.util.Stack;

import ds.trees.TreeNode;
// Lazy Inorder Traversal
public class BSTIterator {
    Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        pushToStack(root);
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public TreeNode next() {
        TreeNode popped = stack.pop();
        pushToStack(popped.right);
        return popped;
    }

    private void pushToStack(TreeNode root) {
        TreeNode current = root;
        while (current != null) {
            stack.push(current);
            current = current.left;
        }
    }

    // Demo
    public static void main(String[] args) {
        /*
                  10
                /    \
              5      12
            /   \   /  \
          4     6 11  13

          Inorder: 4 5 6 10 11 12 13
        */
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(11);
        root.right.right = new TreeNode(13);

        BSTIterator it = new BSTIterator(root);
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        // Expected: 4 5 6 10 11 12 13
    }
}
