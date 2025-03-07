package org.example.programmers.level1;
import java.util.*;

public class Num12954 {
    class Solution {
        public List<Long> solution(int x, int n) {
            List<Long> answer = new ArrayList<>();
            long a = (long) x;
            for(int i=0;i<n;i++){
                answer.add(a);
                a+=x;
            }

            return answer;
        }
    }
}
