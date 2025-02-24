package org.example.programmers.level2;

public class Num12985 {
    class Solution
    {
        public int solution(int n, int a, int b)
        {
            int answer = 0;

            while(n/2 != 0){

                a = (a + 1) / 2;
                b = (b + 1) / 2;
                answer++;
                if(a == b) return answer;
            }

            return answer;
        }
    }
}
