package org.example.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Num2667 {
    static int N;
    static int[][] map;
    static int[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int weight = 0;
    static ArrayList<Integer> weights = new ArrayList<>();
    static int count = 0;//단지 수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new int[N][N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j] == 0 && map[i][j] == 1) {
                    weight = 1;
                    dfs(j, i);
                    weights.add(weight);
                }
            }
        }
        System.out.println(weights.size());
        Collections.sort(weights);
        for (int i = 0; i < weights.size(); i++) {
            System.out.println(weights.get(i));
        }
    }

    public static void dfs(int x, int y) {
        visited[y][x] = 1;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < N && ny < N
                    && visited[ny][nx] == 0 && map[ny][nx] == 1) {
                weight++;
                dfs(nx, ny);
            }
        }
    }
}
