package org.example.baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num9466 {
    static int T, n, count;
    static int[] student;
    static boolean[] visited, done;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        while (T != 0) {
            T--;
            n = Integer.parseInt(br.readLine());

            student = new int[n];
            visited = new boolean[n];
            done = new boolean[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                student[i] = Integer.parseInt(st.nextToken());
            }
            count = 0;
            for (int i = 0; i < student.length; i++) {
                dfs(i);
            }

            System.out.println(n - count);
        }
    }

    static void dfs(int current) {
        int wanted = student[current] - 1;

        if (done[current]) return;
        if (visited[current]) {
            done[current] = true;
            count++;
        }
        visited[current] = true;
        dfs(wanted);
        done[current] = true;
        visited[current] = false;
    }
}
