package org.example.programmers.level2;

import java.util.*;
public class Num131127 {
    class Solution {
        public int solution(String[] want, int[] number, String[] discount) {
            int answer = 0;
            for(int day = 0; day < discount.length;day++){
                Map<String, Integer> map = new HashMap<>();

                for(int j=0;j<want.length;j++){
                    map.put(want[j], number[j]);
                }


                for(int i=day;(i<day + 10);i++){
                    if(i > discount.length-1) break;
                    if(!map.containsKey(discount[i])) continue;
                    map.put(discount[i], map.get(discount[i]) - 1);
                }
                boolean flag = false;
                for(int value : map.values()){
                    if(value > 0) {
                        flag = false;
                        break;
                    }
                    else flag = true;
                }
                if(flag) answer++;
            }

            return answer;
        }
    }
}
