package Strings;

import java.util.*;

public class RankOfTheStudents {

    public long findTotalImbalance(List<Integer> rank) {
        long imbalance = 0;
        int start = 0;
        int step = rank.size();
        while(step>1){
            while(start+step<=rank.size()){
                List<Integer> list = new ArrayList<>(rank.subList(start, start + step));
                Collections.sort(list);
                start++;
                for(int j = 0; j<list.size()-1; j++){
                    if((list.get(j+1))-list.get(j)>1){
                        imbalance++;
                    }
                }
            }
            step--;
            start=0;
        }

        return imbalance;
    }
}
