package org.example.programmers.level2;

public class Num12952 {
    class Solution {
        private int N;
        private boolean[] width;
        private boolean[] diagonal1;
        private boolean[] diagonal2;

        public int solution(int n) {
            this.N = n;
            this.width = new boolean[n];
            this.diagonal1 = new boolean[2 * n];  // 크기 최적화
            this.diagonal2 = new boolean[2 * n];  // 크기 최적화
            return getAns(0);
        }

        private int getAns(int y) {
            if (y == N) return 1;  // 종료 조건 최적화

            int ans = 0;
            for (int i = 0; i < N; i++) {
                if (width[i] || diagonal1[i + y] || diagonal2[i - y + N]) continue;

                width[i] = diagonal1[i + y] = diagonal2[i - y + N] = true;
                ans += getAns(y + 1);
                width[i] = diagonal1[i + y] = diagonal2[i - y + N] = false;
            }
            return ans;
        }
    }
}
