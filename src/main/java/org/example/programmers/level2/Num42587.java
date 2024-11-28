package org.example.programmers.level2;
import java.util.*;
public class Num42587 {
    class Solution {
        public int solution(int[] priorities, int location) {
            int answer = 0;
            PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

            for (int i = 0; i < priorities.length; i++) {
                queue.add(priorities[i]);
            }

            while (!queue.isEmpty()) {
                for(int i=0; i<priorities.length; i++) {
                    if(priorities[i] == queue.peek()) {
                        queue.poll();
                        answer++;
                        if(i == location)
                            return answer;
                    }
                }
            }
            return answer;
        }
    }
}
