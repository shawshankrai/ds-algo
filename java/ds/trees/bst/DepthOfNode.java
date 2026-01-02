package ds.trees.bst;

import ds.trees.TreeNode;

public class DepthOfNode {

    private static int depth(TreeNode node, int target, int depth) {
        if(node == null) return -1;

        if(node.val == target) return depth;

        int left = depth(node.left, target, depth + 1);
        if(left != -1) return left;

        return depth(node.right, target, depth + 1);
    }
    
    private static int depthIter(TreeNode root, int target) {
      TreeNode current = root;
      int depth = 0;

      while(current != null) {
        if(current.val == target) return depth;

        if(current.val > target) {
          current = current.left; 
        } else if(current.val < target) {
          current = current.right;
        }

        depth++;
      }

      return -1;
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

        // System.out.println(depth(root, 4, 0));
        System.out.println(depthIter(root, 4));

    }
}
