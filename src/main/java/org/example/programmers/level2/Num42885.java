package org.example.programmers.level2;

import java.util.*;
public class Num42885 {
    class Solution {
        public int solution(int[] people, int limit) {
            int answer = 0;
            Arrays.sort(people);

            int i = 0;
            int j = people.length -1;

            while(i<=j){
                if(people[j] + people[i] <= limit){
                    j--;
                    i++;
                }else{
                    j--;
                }
                answer++;
            }
            return answer;
        }
    }
}
