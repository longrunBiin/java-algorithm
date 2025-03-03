package org.example.programmers.level1;

public class Num12912 {
    class Solution {
        public long solution(int a, int b) {
            long answer = 0;
            long big = Math.max(a, b);
            long small = Math.min(a, b);

            for(long i = small; i <= big; i++){
                answer+=i;
            }
            return answer;
        }
    }
}
