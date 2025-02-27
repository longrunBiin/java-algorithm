package org.example.programmers.level1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Num1845 {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 1, 2, 3};
        solution(nums);
    }
    public static int solution(int[] nums) {
        int answer = 0;
        int n = nums.length;
        Arrays.sort(nums);
        int count = 1;
        int num = nums[0];
        for (int i = 1; i < n; i++) {
            if (num != nums[i]) {
                count++;
                num = nums[i];
            }
        }
        if (count > n / 2) {
            count = n / 2;
        }
        answer = count;

        return answer;
    }

    public int solution2(int[] nums) {
        Set<Integer> pokemon = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            pokemon.add(nums[i]);
        }
        int n = nums.length/2;

        if(pokemon.size() < n) return pokemon.size();

        return n;
    }
}
