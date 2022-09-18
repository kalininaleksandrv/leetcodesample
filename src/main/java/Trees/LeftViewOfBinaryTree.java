package Trees;

import java.util.List;

public class LeftViewOfBinaryTree {

    //we add this variable to add only one number on each level
    int maxLevel = 0;
    void leftView (TreeNode root, int level, List<Integer> result){

        if(root == null) return;

        if(maxLevel<level) {
            result.add(root.val);
            maxLevel=level;
        }

        leftView(root.left, level+1, result);
        leftView(root.right, level+1, result);
    }
}
