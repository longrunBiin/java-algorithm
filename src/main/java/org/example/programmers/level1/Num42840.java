package org.example.programmers.level1;

import java.util.ArrayList;
import java.util.List;

public class Num42840 {

    class Solution {
        public List<Integer> solution(int[] answers) {
            List<Integer> answer = new ArrayList<>();
            int[] man1 = {1,2,3,4,5};
            int[] man2 = {2,1,2,3,2,4,2,5};
            int[] man3 = {3,3,1,1,2,2,4,4,5,5};
            int sum1 = 0, sum2 = 0, sum3 = 0;

            for(int i=0; i<answers.length;i++){
                if(man1[i % man1.length] == answers[i]) sum1+=1;
                if(man2[i % man2.length] == answers[i]) sum2+=1;
                if(man3[i % man3.length] == answers[i]) sum3+=1;
            }

            int max = 0;
            max = Math.max(sum1, sum2);
            max = Math.max(max, sum3);

            if(sum1 == max) answer.add(1);
            if(sum2 == max) answer.add(2);
            if(sum3 == max) answer.add(3);

            return answer;
        }
    }
}
