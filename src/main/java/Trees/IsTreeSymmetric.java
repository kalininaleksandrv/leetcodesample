package Trees;

public class IsTreeSymmetric {

    public boolean isSymmetric (TreeNode root){
        return areSymmetric(root.left, root.right);
    }

    public boolean areSymmetric(TreeNode left, TreeNode right){
        //if one node is null but mirrored is not - is asymmetric
        if((left==null && right!=null)||(left!=null&&right==null)) return false;
        //if both mirrored nodes are null - is symmetric
        if(left==null && right==null) return true;
        // if both mirrored nodes are exists but they values are different - is asymmetric
        if(left.val!=right.val) return false;
        /*
        if all previous conditions are passed - we must invoke method recursively for both branches from node
        for return true from method, both branches must return true so we combine them with &&
        */
        return areSymmetric(left.left, right.right) && areSymmetric(left.right, right.left);
    }
}
