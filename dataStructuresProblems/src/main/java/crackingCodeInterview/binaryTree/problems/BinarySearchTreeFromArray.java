package crackingCodeInterview.binaryTree.problems;

import crackingCodeInterview.binaryTree.classes.NodeInteger;

import java.util.Arrays;

/*
Minimal Tree: Given a sorted (increasing order) array with unique integer elements, write an algorithm
to create a binary search tree with minimal height.
 */
public class BinarySearchTreeFromArray {

    public NodeInteger orderedArrayToTree(int[] array) {
        if (array == null) {
            return new NodeInteger();
        }

        if (array.length == 1) {
            return new NodeInteger(array[0]);
        }

        if (array.length == 2) {
            return new NodeInteger(array[1], new NodeInteger(array[0]), null);
        }

        int rootIndex = array.length / 2;
        if ((array.length % 2) == 0) {
            rootIndex--;
        }

        return new NodeInteger(
                array[rootIndex],
                orderedArrayToTree(Arrays.copyOfRange(array, 0, rootIndex)),
                orderedArrayToTree(Arrays.copyOfRange(array, rootIndex+1, array.length))
                );
    }
}
