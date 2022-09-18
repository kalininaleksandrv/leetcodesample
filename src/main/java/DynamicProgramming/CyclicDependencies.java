package DynamicProgramming;

import java.util.LinkedList;

/*
the solution of this problem based on DFS algorithm
 */
public class CyclicDependencies {

    public boolean isCyclic (Vertex<Integer> vertex,
                             LinkedList<Vertex<Integer>> path) {
        vertex.setVisited(true);
        // if we reach end of chain we return on previous step to check another branches
        if(vertex.getNeighbours() == null) return isCyclic(path.getLast(), path);
        path.addLast(vertex);
        for (Vertex<Integer> v: vertex.getNeighbours()) {
            if(!v.isVisited()){
                return isCyclic(v, path);
            } else return true; //we return true if meets with first cyclic vertex
        }
        return false;
    }
}
