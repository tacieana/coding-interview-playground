package model;

import lombok.Data;

import java.util.LinkedList;
import java.util.List;

@Data
public class Vertex<T> {
    private T value;
    private boolean visited;
    private List<Vertex<T>> neighbors = new LinkedList<>();

    public Vertex(T value) {
        this.value = value;
    }
}