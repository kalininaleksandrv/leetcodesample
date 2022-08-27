package DynamicProgramming;

import java.util.Map;

public class BroadSearch {

    /*
      we have matrix m/n with random target point
      some cells are blocked to move
      the task - is to find the shortest way from 0:0 point in upper-left corner
      to target
      for example matrix 4X4 and point is 4/3, blocked cells 1:0, 1:1, 1:2
      S X 0 0
      0 X 0 0
      0 X 0 T
      0 0 0 0
     */

    //exponential complexity - each step can lead us to 4 more steps
    // TODO: 16.08.2022 add memoization
    public Map<String, Integer> getShortestWay (int horizontalStart,
                                                int verticalStart,
                                                int matrixSize,
                                                Map<String, Integer> blockedCells,
                                                int step) {

        /*
          we'll move step by step, h+1, h-1, v+1, v-1
          each cell we visit, we will mark as visited
          if h(or v)+1=4 or h(or v)-1=-1 we can't move to this direction
          blocked cells add to visited before start
          if we can't move from current step we check - if its 0:0 we hit the target
          each move we count a steps, if 0:0 reached we return counted steps
         */

        blockedCells.put(verticalStart + ":" + horizontalStart, step);

        //move up, check if we're not reached border and sell upstairs is not already blocked;
        String upSell = verticalStart - 1 + ":" + horizontalStart;
        if (verticalStart - 1 >= 0 && !blockedCells.containsKey(upSell)) {
            return getShortestWay(horizontalStart, verticalStart - 1, matrixSize, blockedCells, step+1);
        }

        //move left
        String leftCell = verticalStart + ":" + (horizontalStart-1);
        if (horizontalStart - 1 >= 0 && !blockedCells.containsKey(leftCell)) {
            return getShortestWay(horizontalStart - 1, verticalStart, matrixSize, blockedCells, step+1);
        }

        //move down
        String downCell = (verticalStart + 1) + ":" + horizontalStart;
        if (verticalStart + 1 <= matrixSize && !blockedCells.containsKey(downCell)) {
            return getShortestWay(horizontalStart, verticalStart + 1, matrixSize, blockedCells, step+1);
        }

        //move right
        String rightCell = verticalStart + ":" + (horizontalStart+1);
        if (horizontalStart + 1 <= matrixSize && !blockedCells.containsKey(rightCell)) {
            return getShortestWay(horizontalStart + 1, verticalStart, matrixSize, blockedCells, step+1);
        }

        return blockedCells;
    }
}
