package org.example.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Num15649{

    static int[] arr = new int[10];
    static Boolean[] isUsed = new Boolean[10];

    public static void func(int num, int n, int m) {
        if (num == m){
            for (int i = 0; i < m; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
        for (int i = 1; i <= n; i++) {
            if (!isUsed[i]) {
                arr[num] = i;
                isUsed[i] = true;
                func(num + 1, n, m);
                isUsed[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i <10; i++) {
            isUsed[i] = false;
        }

        func(0, N, M);

    }


}
