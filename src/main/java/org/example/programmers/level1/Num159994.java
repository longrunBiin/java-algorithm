package org.example.programmers.level1;

import java.util.*;
public class Num159994 {
    class Solution {
        public String solution(String[] cards1, String[] cards2, String[] goal) {
            Queue<String> queue1 = new ArrayDeque<>();
            Queue<String> queue2 = new ArrayDeque<>();
            Queue<String> goalQueue = new ArrayDeque<>();
            for(int i=0; i< cards1.length;i++){
                queue1.add(cards1[i]);
            }
            for(int i=0; i< cards2.length;i++){
                queue2.add(cards2[i]);
            }
            for(int i=0; i< goal.length;i++){
                goalQueue.add(goal[i]);
            }

            for(int i=0;i<goal.length;i++){
                if(!queue1.isEmpty()&&goalQueue.peek().equals(queue1.peek())){
                    goalQueue.poll();
                    queue1.poll();
                }else if(!queue2.isEmpty()&&goalQueue.peek().equals(queue2.peek())){
                    goalQueue.poll();
                    queue2.poll();
                }else return "No";
            }
            if(goalQueue.isEmpty()) return "Yes";
            return "No";
        }
    }
}
