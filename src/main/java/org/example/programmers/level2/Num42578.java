package org.example.programmers.level2;
import java.util.*;

public class Num42578 {
    public static void main(String[] args) {
        String[][] clothes = new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"},
                {"green_turban", "headgear"}};
        Solution.solution(clothes);
    }
    static class Solution {
        public static int solution(String[][] clothes) {
            int answer = 0;
            Map<String, Integer> map = new HashMap<>();

            for(int i=0;i<clothes.length;i++){
                map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0)+1);
                System.out.println(i);
            }
            if(map.size()==1){
                answer = clothes.length;
                return answer;
            }
            int count = 1;
            for (String s : map.keySet()) {
                count *= map.getOrDefault(s, 1) + 1;
            }

            answer = count -1;
            return answer;
        }
    }
}
