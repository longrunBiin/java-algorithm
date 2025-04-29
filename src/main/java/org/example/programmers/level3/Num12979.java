package org.example.programmers.level3;

import java.util.*;
public class Num12979 {
    class Solution {
        public int solution(int n, int[] stations, int w) {
            int answer = 0;
            int range = w * 2 + 1;
            int start = 1;

            for (int station : stations) {
                int left = station - w;
                int right = station + w;

                if (start < left) {
                    int gap = left - start;
                    answer += (gap + range - 1) / range; // ceil division
                }

                start = right + 1; // 다음 탐색 시작점
            }

            // 마지막 기지국 이후에 남은 구간 처리
            if (start <= n) {
                int gap = n - start + 1;
                answer += (gap + range - 1) / range;
            }

            return answer;
        }
    }
}
