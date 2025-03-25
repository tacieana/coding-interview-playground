package theoryexamples;


import model.Vertex;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphBreadthFirstSearch {

    private Vertex<Integer> root;

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

        GraphBreadthFirstSearch graphBreadthFirstSearch = new GraphBreadthFirstSearch();
        graphBreadthFirstSearch.printValueBreadthFirstSearch(v0);
    }

    private void printValueBreadthFirstSearch(Vertex<Integer> root) {
        this.root = root;
        this.traverse();
    }

    private void traverse() {
        Queue<Vertex<Integer>> queue = new LinkedList<>();
        queue.add(this.root);

        while (!queue.isEmpty()) {
            Vertex<Integer> current = queue.poll();

            if (!current.isVisited()) {
                System.out.println(current.getValue());
                current.setVisited(true);
                queue.addAll(current.getNeighbors());
            }
        }
    }
}
