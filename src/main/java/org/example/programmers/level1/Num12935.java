package org.example.programmers.level1;

import java.util.*;
public class Num12935 {
    class Solution {
        public List<Integer> solution(int[] arr) {
            List<Integer> answer = new ArrayList<>();
            int min = Integer.MAX_VALUE;
            for(int i=0;i<arr.length;i++){
                min = Math.min(min, arr[i]);
            }
            int index = 0;
            for(int i=0;i<arr.length;i++){
                if(arr[i] == min){
                    index = i;
                    break;
                }
            }
            for(int i=0;i<arr.length;i++){
                if(i==index){
                    continue;
                }
                answer.add(arr[i]);
            }
            if(answer.isEmpty()) answer.add(-1);
            return answer;
        }
    }
}
