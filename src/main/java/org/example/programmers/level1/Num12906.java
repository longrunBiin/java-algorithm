package org.example.programmers.level1;

import java.util.*;
public class Num12906 {

    public int[] solution(int []arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(arr[0]);
        for(int i=1; i < arr.length; i++){
            if(answer.get(answer.size() - 1) != arr[i])
                answer.add(arr[i]);
            //System.out.println("["+answer.get(i)+"]");
        }

        int[] answer1 = answer.stream().mapToInt(Integer::intValue).toArray();
        return answer1;
    }
}
