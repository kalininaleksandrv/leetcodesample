package DynamicProgramming;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CyclicDependenciesTest {

    @Test
    void isNotCyclic() {
        CyclicDependencies cyclicDependencies = new CyclicDependencies();
        Vertex<Integer> a = new Vertex<>(1, false, new LinkedList<>());
        Vertex<Integer> b = new Vertex<>(2, false, new LinkedList<>());
        Vertex<Integer> c = new Vertex<>(3, false, new LinkedList<>());
        a.getNeighbours().add(b);
        a.getNeighbours().add(c);
        assertFalse(cyclicDependencies.isCyclic(a, new LinkedList<>()));
    }

    @Test
    void isCyclic() {
        CyclicDependencies cyclicDependencies = new CyclicDependencies();
        Vertex<Integer> a = new Vertex<>(1, false, new LinkedList<>());
        Vertex<Integer> b = new Vertex<>(2, false, new LinkedList<>());
        Vertex<Integer> c = new Vertex<>(3, false, new LinkedList<>());
        a.getNeighbours().add(b);
        b.getNeighbours().add(c);
        c.getNeighbours().add(a);
        assertTrue(cyclicDependencies.isCyclic(a, new LinkedList<>()));
    }
}