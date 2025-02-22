package org.example.programmers.level1;

import java.util.*;
public class Num92334 {
    class Solution {
        public int[]solution(String[] id_list, String[] report, int k) {
            int[] answer = new int[id_list.length];
            Map<String, Set<String>> reportMap = new HashMap<>();
            Map<String, Integer> reportedCount = new HashMap<>();
            //이용자별 신고한 인원 넣기
            for(int i=0;i<id_list.length;i++){
                String id = id_list[i];
                reportMap.put(id, new HashSet<>());
            }

            for(int i=0;i<report.length;i++){
                String[] split = report[i].split(" ");
                reportMap.putIfAbsent(split[0], new HashSet<>());
                reportMap.get(split[0]).add(split[1]);
            }
            //이용자별 신고당한 횟수 계산
            for(int i=0;i<id_list.length;i++){
                reportMap.get(id_list[i])
                        .forEach(man -> reportedCount.put(man, reportedCount.getOrDefault(man, 0) + 1));
            }

            for (int i = 0; i < id_list.length; i++) {
                String user = id_list[i];
                for (String reportedUser : reportMap.get(user)) {
                    if (reportedCount.getOrDefault(reportedUser, 0) >= k) {
                        answer[i]++; // 정지된 유저를 신고한 경우 카운트 증가
                    }
                }
            }



            return answer;
        }
    }
}
