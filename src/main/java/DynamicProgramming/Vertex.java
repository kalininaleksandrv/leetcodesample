package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Vertex<T> {
    private final T val;
    private boolean isVisited;
    private List<Vertex<T>> neighbours;

    Vertex(T val, boolean isVisited, List<Vertex<T>> neighbours) {
        this.val = val;
        this.isVisited = isVisited;
        this.neighbours = neighbours;
    }

    public T getVal() {
        return val;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public List<Vertex<T>> getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(List<Vertex<T>> neighbours) {
        this.neighbours = neighbours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vertex<?> vertex = (Vertex<?>) o;

        if (isVisited != vertex.isVisited) return false;
        if (!val.equals(vertex.val)) return false;
        return Objects.equals(neighbours, vertex.neighbours);
    }

    @Override
    public int hashCode() {
        int result = val.hashCode();
        result = 31 * result + (isVisited ? 1 : 0);
        result = 31 * result + (neighbours != null ? neighbours.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "val=" + val +
                ", isVisited=" + isVisited +
                '}';
    }
}
