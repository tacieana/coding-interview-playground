package leetcode.binarytree.hard;

import leetcode.binarytree.classes.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/* Serialization is the process of converting a data structure or object into a sequence of bits
so that it can be stored in a file or memory buffer, or transmitted across a network connection
link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree.
There is no restriction on how your serialization/deserialization algorithm should work.
You just need to ensure that a binary tree can be serialized to a string and this string can be
deserialized to the original tree structure.

Clarification: The input/output format is the same as how LeetCode serializes a binary tree.
You do not necessarily need to follow this format, so please be creative and come up with different
approaches yourself.
Runtime 74.64% / Memory 77.19% */
public class Codec {

    public String serialize(TreeNode root) {
        if (root == null) {
            return "null";
        }
        StringBuilder builder = new StringBuilder();
        builder.append(root.val);
        builder.append(",");
        builder.append(serialize(root.left));
        builder.append(",");
        builder.append(serialize(root.right));
        return builder.toString();
    }

    public TreeNode deserialize(String data) {

        Queue<String> fila = new LinkedList<>();
        for(String value : data.split(",")) {
            fila.add(value);
        }
        return deserializeQueue(fila);
    }

    private TreeNode deserializeQueue(Queue<String> queue) {
        String actualValue = queue.poll();
        if(actualValue == null || actualValue.equals("null")) {
            return null;
        }
        return new TreeNode(
                Integer.parseInt(actualValue),
                deserializeQueue(queue),
                deserializeQueue(queue)
        );
    }
}
