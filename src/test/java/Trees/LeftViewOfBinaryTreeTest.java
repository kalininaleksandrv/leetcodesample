package Trees;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LeftViewOfBinaryTreeTest {

    @Test
    void leftView() {

        LeftViewOfBinaryTree leftViewOfBinaryTree = new LeftViewOfBinaryTree();

        List<Integer> res = new ArrayList<>();

        TreeNode root = new TreeNode(4,
                new TreeNode(2, null, new TreeNode(3)),
                new TreeNode(7, new TreeNode(6), new TreeNode(9)));

        leftViewOfBinaryTree.leftView(root, 1, res);
        assertEquals(3, res.size());
        assertTrue(res.contains(4));
        assertTrue(res.contains(2));
        assertTrue(res.contains(3));
    }

    @Test
    void leftView2() {

        LeftViewOfBinaryTree leftViewOfBinaryTree = new LeftViewOfBinaryTree();

        List<Integer> res2 = new ArrayList<>();

        TreeNode root2 = new TreeNode(4,
                new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                new TreeNode(7, new TreeNode(6), new TreeNode(9)));

        leftViewOfBinaryTree.leftView(root2, 1, res2);
        assertEquals(3, res2.size());
        assertTrue(res2.contains(4));
        assertTrue(res2.contains(2));
        assertTrue(res2.contains(1));

    }
}