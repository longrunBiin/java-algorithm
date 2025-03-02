package org.example.programmers.level1;

public class Num12925 {
    class Solution {
        public int solution(String s) {
            String answer = "";
            char[] c = s.toCharArray();
            for(int i=0;i<c.length;i++){
                if(c[i] == '-') continue;
                answer += c[i];
            }
            int ans = Integer.parseInt(answer);
            if(c[0] == '-') return ans - (ans * 2);

            return ans;
        }
    }
}
