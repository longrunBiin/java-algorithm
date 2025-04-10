package org.example.programmers.level2;

import java.util.*;
public class Num64065 {
    class Solution {
        public List<Integer> solution(String s) {
            s = s.substring(2, s.length()-2);
            String[] split = s.split("\\},\\{");

            Arrays.sort(split, Comparator.comparingInt(String::length));
            List<Integer> answer = new ArrayList<>();
            for(int i=0;i<split.length;i++){
                String[] tuple = split[i].split(",");
                if(tuple.length == answer.size()+1){
                    for(int j = 0;j<tuple.length;j++){
                        int a = Integer.parseInt(tuple[j]);
                        if(!answer.contains(a)){
                            answer.add(a);
                            break;
                        }
                    }
                }

            }





            return answer;
        }
    }
}
