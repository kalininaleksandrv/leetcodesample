package DynamicProgramming;

public class DepthSearch {

    public void traverseGraphRecursively(Vertex<Integer> vertex) {
        vertex.setVisited(true);
        System.out.println(vertex);
        if (vertex.getNeighbours() == null) return;
        vertex.getNeighbours()
                .stream()
                .filter(i -> !i.isVisited()) //avoid cyclic graph problem
                .forEach(this::traverseGraphRecursively);
    }
}

