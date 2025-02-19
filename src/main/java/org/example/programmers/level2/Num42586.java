package org.example.programmers.level2;
import java.util.*;
public class Num42586 {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answerList = new ArrayList<>();
        int q = 0;
        int count = 1;
        int needDays0 = (100 - progresses[0]) / speeds[0] ;
        if((100 - progresses[0]) % speeds[0] > 0)
            needDays0++;

        for(int i=1;i<progresses.length;i++){
            int needDays = (100 - progresses[i]) / speeds[i] ;
            if((100 - progresses[i]) % speeds[i] > 0)
                needDays++;

            if(needDays <= needDays0){
                count++;
                continue;
            }
            answerList.add(count);
            count = 1;
            needDays0 = needDays;
        }
        answerList.add(count);

        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }

}
