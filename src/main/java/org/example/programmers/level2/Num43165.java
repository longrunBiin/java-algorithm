package org.example.programmers.level2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Num43165 {
    class Solution {
        static int count = 0;
        public int solution(int[] numbers, int target) {
            int answer = 0;
            dfs(numbers, target, 0, 0);
            answer = count;
            Arrays.sort(numbers);
            return answer;
        }

        public static void dfs(int[] numbers, int target, int current, int sum){
            if(sum == target && current == numbers.length){
                count++;
                return;
            }
            while(current != numbers.length){
                dfs(numbers, target, current+1, sum + numbers[current]);
                dfs(numbers, target, current+1, sum - numbers[current]);
                return;
            }

        }
    }
}
