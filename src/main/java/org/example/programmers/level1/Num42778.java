package org.example.programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Num42778 {
    static class Solution {
        public static void main(String[] args) {
            int[] a = new int[]{1, 5, 2, 6, 3, 7, 4};
            int[][] c = new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
            solution(a, c);

        }
        public static int[] solution(int[] array, int[][] commands) {

            List<Integer> result = new ArrayList<>();
            int length = 0;

            while(length != commands.length - 1){
                int i = commands[length][0];
                int j = commands[length][1];
                int k = commands[length][2];

                int[] filter = new int[j - i + 1];
                for(int q = 0; q < j - i + 1; q++){
                    filter[q] = array[i + q - 1];

                }

                Arrays.sort(filter);
                result.add(filter[k-1]);
                System.out.println(filter[k-1]);

                length++;
            }
            int[] answer = new int[result.size()+1];
            for(int i = 0; i < result.size(); i++){
                answer[i] = result.get(i);
                System.out.println(answer[i]);
            }


            return answer;


        }
    }
}
