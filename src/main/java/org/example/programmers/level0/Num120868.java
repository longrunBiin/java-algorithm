package org.example.programmers.level0;

public class Num120868 {
    class Solution {
        public int solution(int[] sides) {
            int answer = 0;
            int max = Math.max(sides[0], sides[1]);
            int min = Math.min(sides[0], sides[1]);

            for(int i = max - min;i < max; i++){
                answer++;
            }

            for(int i = max + 1; i< sides[0] + sides[1]; i++){
                answer++;
            }

            return answer;
        }
    }
}
