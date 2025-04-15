package org.example.programmers.level2;

import java.util.*;
public class Num154539 {
    class Solution {
        public List<Integer> solution(int[] numbers) {
            Stack<Integer> stack = new Stack<>();
            int n = numbers.length;
            int[] answer = new int[n];

            Arrays.fill(answer, -1); // 초기값은 전부 -1

            for (int i = n - 1; i >= 0; i--) {
                // 현재 값보다 작거나 같은 건 스택에서 제거
                while (!stack.isEmpty() && stack.peek() <= numbers[i]) {
                    stack.pop();
                }

                if (!stack.isEmpty()) {
                    answer[i] = stack.peek();
                }

                stack.push(numbers[i]);
            }

            // 결과 리스트로 변환
            List<Integer> result = new ArrayList<>();
            for (int num : answer) {
                result.add(num);
            }
            return result;
        }
    }
}
