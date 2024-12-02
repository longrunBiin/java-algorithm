package org.example.programmers.level2;

import java.util.Arrays;

public class Num42747 {
    class Solution {
        public int solution(int[] citations) {
            int answer = 0;
            int n = citations.length;
            Arrays.sort(citations);

            for(int i = 0;i<n;i++){
                int hIndex = n - i;
                if(citations[i] >=hIndex){
                    answer = hIndex;
                    break;
                }
            }
            return answer;
        }
    }
}
