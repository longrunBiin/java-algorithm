package org.example.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num1182 {

    static int N, S;
    static int[] array;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st1.nextToken());
        S = Integer.parseInt(st1.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st2.nextToken());
        }


        func(0, 0);
        if (S==0)count--;
        System.out.println(count);
    }

    public static void func(int sum, int at) {
        if (at==N){
            if (sum == S){
                count++;

            }
            return;
        }
        // 현재 원소를 선택하는 경우
        func(sum + array[at], at + 1);

        // 현재 원소를 선택하지 않는 경우
        func(sum, at + 1);
    }
}
