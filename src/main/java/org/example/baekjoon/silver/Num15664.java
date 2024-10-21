package org.example.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Num15664 {

    static int N, M;
    static ArrayList<Integer> array;
    static boolean[] isUsed = new boolean[10];
    static int[] answer = new int[10];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        array = new ArrayList<>();
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
        }

        int before = 0;
        for (int i = at; i < array.size(); i++) {
            if (!isUsed[i] && before != array.get(i)) {
                answer[depth] = array.get(i);
                isUsed[i] = true;
                before = array.get(i);
                func(i + 1, depth + 1);
                isUsed[i] = false;
            }

        }
    }
}
