package org.example.programmers.level2;

public class Num12911 {
    class Solution {
        public int solution(int n) {
            int targetBitCount = Integer.bitCount(n);
            int answer = n + 1;

            while (Integer.bitCount(answer) != targetBitCount) {
                answer++;
            }

            return answer;
        }
    }
}
