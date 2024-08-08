package org.example.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num15650 {

    static int[] array;
    static int n, m;

    public static void func(int num, int at) {
        if (num == m) {
            for (int i : array) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }
        for (int i = at; i <= n; i++) {
            array[num] = i;
            func(num+1, i+1);

        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        array = new int[m];
        func(0, 1);
    }
}
