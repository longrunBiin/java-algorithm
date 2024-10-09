package org.example.baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Num13913 {
    static int N, K;
    static boolean[] visited = new boolean[100001];
    static int[] route = new int[100001]; // 경로를 추적하기 위한 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bfs(N); // N에서 시작

        // 경로 추적 및 출력
        Stack<Integer> stack = new Stack<>();
        for (int i = K; i != N; i = route[i]) { // K에서 N까지 역추적
            stack.push(i);
        }
        stack.push(N); // 시작점 N 추가

        // 스택을 사용해 경로 출력
        System.out.println(stack.size() - 1); // 총 걸린 시간 출력
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int current = q.poll();

            if (current == K) { // 도착 지점에 도달하면 종료
                return;
            }

            // 1. 순간 이동
            if (current * 2 <= 100000 && !visited[current * 2]) {
                q.add(current * 2);
                visited[current * 2] = true;
                route[current * 2] = current; // 이전 위치 기록
            }

            // 2. +1 이동
            if (current + 1 <= 100000 && !visited[current + 1]) {
                q.add(current + 1);
                visited[current + 1] = true;
                route[current + 1] = current; // 이전 위치 기록
            }

            // 3. -1 이동
            if (current - 1 >= 0 && !visited[current - 1]) {
                q.add(current - 1);
                visited[current - 1] = true;
                route[current - 1] = current; // 이전 위치 기록
            }
        }
    }
}
