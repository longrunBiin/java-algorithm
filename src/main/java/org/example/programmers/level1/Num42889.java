package org.example.programmers.level1;
import java.util.*;

public class Num42889 {

    class Solution {
        public int[] solution(int N, int[] stages) {
            //순차적으로 해당 라운드를 통과한 인원과 못한 인원을 구한다.
            //실패율 배열에 각 라운드별 실패율을 저장한다.
            int[] challenger = new int [N+2];
            for(int i=0; i< stages.length;i++){
                challenger[stages[i]] += 1;
            }
            double playerCount = stages.length;
            Map<Integer, Double> failRatio = new HashMap<>();
            for(int i=1;i<=N;i++){
                if(challenger[i] == 0){
                    failRatio.put(i, 0.);
                }else{
                    failRatio.put(i, challenger[i] / playerCount);
                    playerCount -= challenger[i];
                }
            }

            return failRatio.entrySet().stream()
                    .sorted((o1, o2) -> Double.compare(o2.getValue(), o1.getValue()))
                    .mapToInt(Map.Entry::getKey).toArray();
        }
    }
}
