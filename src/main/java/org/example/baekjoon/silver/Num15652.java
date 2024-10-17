package org.example.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num15652 {
    static int N, M;
    static int[] array = new int[10];
    static boolean[] isUsed = new boolean[10];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        func(1, 0);
        System.out.println(sb);
    }

    public static void func(int at, int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(array[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = at; i <= N; i++) {

            array[depth] = i;
            func(i, depth + 1);

        }
    }
}
