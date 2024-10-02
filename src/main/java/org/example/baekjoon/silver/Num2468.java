package org.example.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Num2468 {

    static int N;
    static int max = 0;
    static int[][] map;
    static boolean[][]check;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy ={0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, map[i][j]);
            }
        }

        int result = 0;
        for (int h = 0; h < max+1; h++) {
            check = new boolean[N][N];
            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!check[i][j] && map[i][j] > h) {
                        count += dfs(i,j,h);
                    }

                }
            }
            result = Math.max(result, count);
        }
        System.out.println(result);

    }

    public static int dfs(int x, int y, int height) {
        check[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            if (check[nx][ny]) continue;
            if (map[nx][ny] > height) {
                dfs(nx, ny, height);
            }
        }

        return 1;
    }
}
