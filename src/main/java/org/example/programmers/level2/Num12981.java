package org.example.programmers.level2;

import java.util.*;
public class Num12981 {
    class Solution {
        public int[] solution(int n, String[] words) {
            Set<String> set = new LinkedHashSet<>();
            set.add(words[0]);
            for(int i=1;i<words.length;i++){
                String previous = words[i-1];
                if(previous.charAt(previous.length()-1) == words[i].charAt(0)
                        && !set.contains(words[i])){
                    set.add(words[i]);
                }else{
                    System.out.println(i+",");
                    int number = i % n + 1;
                    if(number > n) number -= n;
                    int seq = i/n + 1;

                    return new int[]{number, seq};
                }
            }

            return new int[]{0, 0};
        }
    }
}
