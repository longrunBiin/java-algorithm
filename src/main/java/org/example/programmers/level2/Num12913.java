package org.example.programmers.level2;

public class Num12913 {
    class Solution {
        int solution(int[][] land) {
            int n = land.length;
            int[][] dp = new int[n][4]; // 열은 항상 4개

            // 초기화 (맨 아래 행은 그대로 사용)
            for (int j = 0; j < 4; j++) {
                dp[n - 1][j] = land[n - 1][j];
            }

            // 아래에서 위로 올라가면서 계산
            for (int i = n - 2; i >= 0; i--) {
                for (int j = 0; j < 4; j++) {
                    int max = 0;
                    for (int k = 0; k < 4; k++) {
                        if (k != j) { // 같은 열은 연속해서 고를 수 없음
                            max = Math.max(max, dp[i + 1][k]);
                        }
                    }
                    dp[i][j] = land[i][j] + max;
                }
            }

            // 최종적으로 맨 윗줄에서 가장 큰 값이 답
            int answer = 0;
            for (int j = 0; j < 4; j++) {
                answer = Math.max(answer, dp[0][j]);
            }

            return answer;
        }
    }
}
