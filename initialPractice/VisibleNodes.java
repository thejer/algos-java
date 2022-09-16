package javaSolutions.initialPractice;

public class VisibleNodes {
    int depth(TreeNode node) {
        if (node == null) return 0;
        int rightDepth = depth(node.right);
        int leftDepth = depth(node.left);
        return Math.max(rightDepth, leftDepth) + 1;
    }

    int visibleNodes(TreeNode root) {
        // Write your code here
        return depth(root);
    }
}
