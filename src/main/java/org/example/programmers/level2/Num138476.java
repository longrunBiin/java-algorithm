package org.example.programmers.level2;

import java.util.*;
public class Num138476 {
    class Solution {
        public int solution(int k, int[] tangerine) {
            //배열의 인덱스를 크기, 값을 갯수로 설정
            //배열을 내림차순으로 정렬
            //k보다 같거나 큰 경우까지의 갯수를 구함
            int answer = 0;
            Map<Integer, Integer> map = new TreeMap<>();

            for(int i=0;i<tangerine.length;i++){
                map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
            }
            List<Integer> counts = new ArrayList<>(map.values());
            counts.sort(Collections.reverseOrder());

            for (int count : counts) {
                k -= count;
                answer++;
                if (k <= 0) return answer;
            }
            return answer;
        }
    }
}
