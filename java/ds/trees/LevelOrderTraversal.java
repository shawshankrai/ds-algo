package ds.trees;

import java.util.Queue;
import java.util.LinkedList;

public class LevelOrderTraversal {
    private static void levelOrder(TreeNode root) {
        if(root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                System.out.print(node.val + " ");

                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }

            System.out.println();
        }
    }
    public static void main(String[] args) {
        /*
                1
               / \
              2   3
             / \
            4   5

            Output:
            1
            2 3
            4 5
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        levelOrder(root);
    }
}
