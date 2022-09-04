package Trees;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IsTreeSymmetricTest {

    @Test
    void isSymmetric() {
        /*
        symmetric in this care means mirrored
        if all mirrored node of tree are equal by value or both null - tree is symmetric
         */
        TreeNode symmetric = new TreeNode(3, new TreeNode(2), new TreeNode(2));
        TreeNode symmetric2 = new TreeNode(3,
                new TreeNode(2,
                        new TreeNode(5), null),
                new TreeNode(2,
                        null, new TreeNode(5)));
        TreeNode asymmetric1 = new TreeNode(3, new TreeNode(2), new TreeNode(4));
        TreeNode asymmetric2 = new TreeNode(3, new TreeNode(2), null);
        TreeNode asymmetric3 = new TreeNode(3,
                new TreeNode(2,
                        new TreeNode(5), null),
                new TreeNode(2,
                        new TreeNode(5), null));
        IsTreeSymmetric isTreeSymmetric = new IsTreeSymmetric();
        assertTrue(isTreeSymmetric.isSymmetric(symmetric));
        assertTrue(isTreeSymmetric.isSymmetric(symmetric2));
        assertFalse(isTreeSymmetric.isSymmetric(asymmetric1));
        assertFalse(isTreeSymmetric.isSymmetric(asymmetric2));
        assertFalse(isTreeSymmetric.isSymmetric(asymmetric3));
    }
}