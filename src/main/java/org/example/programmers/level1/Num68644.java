package org.example.programmers.level1;

import java.util.*;

class Num68644 {
    class Solution {
        public int[] solution(int[] numbers) {
            HashSet<Integer> set = new HashSet<>();
            int a = 0;
            for (int index = 0; index < numbers.length; index++) {
                for (int i = index + 1; i < numbers.length; i++) {
                    set.add(numbers[index] + numbers[i]);
                }
            }

            return set.stream().sorted().mapToInt(Integer::intValue).toArray();
        }
    }
}