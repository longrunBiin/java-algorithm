package org.example.programmers.level2;

import java.util. *;
public class Num12941 {
    class Solution
    {
        public int solution(int[] A, int[] B) {
            Arrays.sort(A);  // A는 오름차순 정렬
            Arrays.sort(B);

            int size = A.length;
            int answer = 0;

            // A는 오름차순, B는 내림차순으로 곱하기
            for (int i = 0; i < size; i++) {
                answer += A[i] * B[size - i - 1];
            }

            return answer;
        }
    }
}
