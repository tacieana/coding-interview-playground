package theoryexamples;

import model.Vertex;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class GraphDepthFirstSearch {

    public static void main(String[] args) {
        Vertex<Integer> v0 = new Vertex<>(0);
        Vertex<Integer> v1 = new Vertex<>(1);
        Vertex<Integer> v2 = new Vertex<>(2);
        Vertex<Integer> v3 = new Vertex<>(3);
        Vertex<Integer> v4 = new Vertex<>(4);
        Vertex<Integer> v5 = new Vertex<>(5);
        Vertex<Integer> v6 = new Vertex<>(6);

        v0.setNeighbors(Arrays.asList(v1, v2));
        v1.setNeighbors(Arrays.asList(v3, v4));
        v4.setNeighbors(Arrays.asList(v5, v6));
        v6.setNeighbors(List.of(v0));

        GraphDepthFirstSearch graphDepthFirstSearch = new GraphDepthFirstSearch();
        //System.out.println("Stack implementation");
        //graphDepthFirstSearch.traverseStack(v0);

        System.out.println("Recursive implementation");
        graphDepthFirstSearch.traverseRecursive(v0);
    }

    private void traverseStack(Vertex<Integer> root) {
        Stack<Vertex<Integer>> stack = new Stack();
        stack.push(root);

        while (!stack.isEmpty()) {
            Vertex<Integer> currentValue = stack.pop();

            if (!currentValue.isVisited()) {
                System.out.println(currentValue.getValue());
                currentValue.setVisited(true);

                Collections.reverse(currentValue.getNeighbors());
                currentValue.getNeighbors().forEach(neighbor -> stack.push(neighbor));
            }
        }
    }


    private void traverseRecursive(Vertex<Integer> current) {
        if (current != null && !current.isVisited()) {
            System.out.println(current.getValue());
            current.setVisited(true);
            current.getNeighbors().forEach(neighbor -> {
                traverseRecursive(neighbor);
            });
        }
    }
}
