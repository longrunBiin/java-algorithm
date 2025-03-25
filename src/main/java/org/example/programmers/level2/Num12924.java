package org.example.programmers.level2;

public class Num12924 {
    class Solution {
        public int solution(int n) {
            int answer = 1; /* 자기 자신은 무조건 포함이므로 1부터 시작 (n 일때 n 도 포함된다) */

            /* 1부터 시작 */
            for (int i = 1; i < n; i++) {
                int sum = i;

                /* i + 1 부터 n 포함 까지 */
                for (int j = i + 1; j <= n; j++) {
                    sum += j;

                    if (sum == n) { /* n 일 경우 */
                        answer += 1;
                        break;
                    } else if (sum > n) { /* sum 이 n 보다 커진 이후로는 해당 i의 경우가 없다고 판단 */
                        break;
                    }
                }
            }
            return answer;
        }
    }
//0 1 3 6 10 15 21 28 36 ...
}
