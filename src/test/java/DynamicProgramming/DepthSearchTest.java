package DynamicProgramming;

import org.junit.jupiter.api.Test;

import java.util.List;

class DepthSearchTest {

    /*
    only general idea of DFS, not returns values just print all vertex
     */
    @Test
    void traverseGraphRecursively() {
        DepthSearch depthSearch = new DepthSearch();
        Vertex<Integer> vertex = new Vertex<>(1, false, List.of(new Vertex<>(2, false, null),
                new Vertex<>(3, false, null)));

        depthSearch.traverseGraphRecursively(vertex);
    }
}