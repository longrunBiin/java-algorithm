package org.example.programmers.level2;
import java.util.*;

public class Num42626 {
    class Solution {
        public int solution(int[] scoville, int K) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();

            for(int i=0; i<scoville.length;i++){
                pq.add(scoville[i]);
            }

            int answer = 0;
            while(true){
                int min = pq.poll();
                if(pq.size()<1 && min < K) return -1;

                if(min >= K) break;
                int secMin = pq.poll();

                pq.add(min + (secMin*2));
                answer++;
            }


            return answer;
        }
    }
}
