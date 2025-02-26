package org.example.programmers.level3;

import java.util.*;
public class Num77486 {

    class Solution {

        public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
            Map<String, String> enrollMap = new HashMap<>();
            Map<String, Integer> resultMap = new HashMap<>();
            for(int i=0;i<enroll.length;i++){
                enrollMap.put(enroll[i], referral[i]);
            }


            for(int i=0;i<seller.length;i++){
                String currentName = seller[i];
                int money = amount[i] * 100;

                while(money > 0 && !currentName.equals("-")){
                    resultMap.put(currentName, resultMap.getOrDefault(currentName, 0) + money - (money / 10));
                    currentName = enrollMap.get(currentName);
                    money/=10;
                }
            }

            int[]answer = new int[enroll.length];
            for(int i=0;i<enroll.length;i++){
                answer[i] = resultMap.getOrDefault(enroll[i], 0);
            }


            return answer;
        }
    }
}
