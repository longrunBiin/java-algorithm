package org.example.programmers.level2;

import java.util.*;

public class Num12939 {
    class Solution {
        public String solution(String s) {
            String answer = "";
            String[] split = s.split(" ");

            int[] list = Arrays.stream(split)
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            for(int i : list){
                max = Math.max(i, max);
                min = Math.min(i, min);
            }

            return String.valueOf(min) + " " + String.valueOf(max);
        }
    }
}
