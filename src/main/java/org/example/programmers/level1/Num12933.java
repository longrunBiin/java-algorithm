package org.example.programmers.level1;

import java.util.*;
public class Num12933 {
    class Solution {
        public long solution(long n) {
            long answer = 0;
            PriorityQueue<Long> pq = new PriorityQueue<>(Comparator.reverseOrder());

            while(n!=0){
                long temp = n%10;
                pq.add(temp);
                n/=10;
            }

            while(!pq.isEmpty()){
                answer += pq.poll();
                answer*=10;
            }


            return answer/10;
        }
    }
}
