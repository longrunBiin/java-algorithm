package org.example.programmers.level1;
import java.util.*;

public class Num12910 {
    class Solution {
        public int[] solution(int[] arr, int divisor) {

            int[] answer = Arrays.stream(arr)
                    .filter(a -> a % divisor == 0)
                    .sorted()
                    .toArray();

            if(answer.length == 0){
                return new int[]{-1};
            }
            return answer;
        }
    }
}
