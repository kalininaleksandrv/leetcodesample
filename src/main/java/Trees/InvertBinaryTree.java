package Trees;

public class InvertBinaryTree {

    TreeNode invertInplace(TreeNode root) {
        if (root == null) return root;
        TreeNode left = invert(root.left);
        TreeNode right = invert(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    TreeNode invert(TreeNode root) {
        if (root == null) return root;
        return new TreeNode(root.val, invert(root.right), invert(root.left));
    }
}
