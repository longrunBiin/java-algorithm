package org.example.programmers.level2;

import java.util.*;
public class Num42888 {
    class Solution {
        public List<String> solution(String[] record) {
            List<String> answer = new ArrayList<>();
            Map<String, String> map = new HashMap<>();
            for(int i=0;i<record.length;i++){
                if(record[i].startsWith("Enter") || record[i].startsWith("Change")){
                    String[] split = record[i].split(" ");
                    map.put(split[1], split[2]);
                }
            }


            for(int i=0;i<record.length;i++){
                StringBuilder sb = new StringBuilder();
                String[] split = record[i].split(" ");
                String nickName = map.get(split[1]);
                if(record[i].startsWith("Enter")){
                    sb.append(nickName).append("님이 들어왔습니다.");
                    answer.add(sb.toString());
                }else if(record[i].startsWith("Leave")){
                    sb.append(nickName).append("님이 나갔습니다.");
                    answer.add(sb.toString());
                }
            }


            return answer;
        }
    }
}
