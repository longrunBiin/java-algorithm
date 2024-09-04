package org.example.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Num1021 {
    public static void main(String[] args) throws IOException {
        int N, M, count = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st1.nextToken());
        M = Integer.parseInt(st1.nextToken());

        LinkedList<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            deque.add(i);
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int index = Integer.parseInt(st.nextToken());
            int target = deque.indexOf(index);
            int half;
            if(deque.size() % 2 == 0) {
                half = deque.size() / 2 - 1;
            }
            else {
                half = deque.size() / 2;
            }
            if (target <= half) {  // 왼쪽으로 회전
                for (int j = 0; j < target; j++) {
                    int num = deque.pollFirst();
                    deque.offerLast(num);
                    count++;
                }
            } else {  // 오른쪽으로 회전
                for (int j = 0; j < deque.size() - target; j++) {
                    int num = deque.pollLast();
                    deque.offerFirst(num);
                    count++;
                }
            }

            deque.pollFirst();
        }
        System.out.println(count);
    }
}
