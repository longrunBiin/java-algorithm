package org.example.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num12852 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];
        //경로
        int[] route = new int[n + 1];

        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + 1;
            route[i] = i - 1;
            if (i % 2 == 0 && dp[i] > dp[i/2] + 1) {
                dp[i] =dp[i / 2] + 1;
                route[i] = i / 2;
            }
            if (i % 3 == 0 && dp[i] > dp[i/3] + 1) {
                dp[i] = dp[i / 3] + 1;
                route[i] = i / 3;
            }
        }
        System.out.println(dp[n]);
        int cur = n;
        while (true){
            System.out.print(cur + " ");
            if (cur == 1) {
                break;
            }
            cur = route[cur];
        }
    }
}
