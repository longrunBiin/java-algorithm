package org.example.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Num6603 {
    static int k;
    static ArrayList<Integer> array;
    static int[] lotto;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if (k == 0) return;
            array = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                array.add(Integer.parseInt(st.nextToken()));
            }
            lotto = new int[50];

            func(0, 0);
            System.out.println();
        }
    }


    public static void func(int at, int depth) {
        StringBuilder sb = new StringBuilder();
        if (depth == 6) {
            for (int i = 0; i < 6; i++) {
                sb.append(lotto[i]).append(' ');
            }
            System.out.println(sb);
            return;
        }

        for (int i = at; i < k; i++) {
            lotto[depth] = array.get(i);
            func(i + 1, depth + 1);
        }
    }
}
