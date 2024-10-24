package org.example.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Num15688 {
    static int n;
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = (Integer.parseInt(br.readLine()));
        }

        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            sb.append(nums[i]).append("\n");
        }
        System.out.println(sb);
    }
}
