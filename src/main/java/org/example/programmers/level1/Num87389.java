package org.example.programmers.level1;

public class Num87389 {
    class Solution {
        public int solution(int n) {
            int answer = 0;
            for(int i=1;i<n;i++){
                if(n%i == 1) return i;
            }
            return answer;
        }
    }
}
