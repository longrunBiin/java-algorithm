package org.example.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Num15656 {

    static int N, M;
    static ArrayList<Integer> array;
    static int[] answer;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        array = new ArrayList<>();
        answer = new int[10];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array.add(Integer.parseInt(st2.nextToken()));
        }
        array.sort(Comparator.naturalOrder());

        func(0, 0);
        System.out.println(sb);
    }

    public static void func(int at, int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(answer[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
                answer[depth] = array.get(i);
                func(i, depth + 1);

        }
    }
}
