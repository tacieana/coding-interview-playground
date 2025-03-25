package leetcode.binarytree.medium;

import leetcode.binarytree.classes.TreeNode;

import java.util.ArrayList;
import java.util.List;

/* Given the root of a binary tree, imagine yourself standing on the right side of it,
return the values of the nodes you can see ordered from top to bottom.
Runtime 100.00% / Memory 62.96%
*/
public class RightSideView {

    private final List<Integer> rightView = new ArrayList();

    public List<Integer> rightSideView(TreeNode root) {
        addView(root, 0);
        return rightView;
    }

    private void addView(TreeNode node, int currentSize) {
        if (node == null) return;

        if (currentSize == rightView.size()) {
            rightView.add(node.val);
        }
        addView(node.right, currentSize + 1);
        addView(node.left, currentSize + 1);
    }
}
