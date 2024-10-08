package org.example.baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Num2146 {
    static int N;
    static int[][] world, land;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        world = new int[N][N];
        land = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                world[i][j] = Integer.parseInt(st.nextToken());
                land[i][j] = 0;
            }
        }

        checkLand(); //대륙을 구별
        int count = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (world[i][j] == 1) {
                    count = Math.min(count, bfs(j, i));
                }
            }
        }
        System.out.println(count);
    }

    public static int bfs(int x, int y) {
        Queue<Position> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        q.add(new Position(x, y, 0));
        visited[x][y] = true;
        int currentLand = land[y][x];

        while (!q.isEmpty()) {
            Position now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (world[ny][nx] == 0 && !visited[ny][nx]) {
                    visited[ny][nx] = true;
                    q.add(new Position(nx, ny, now.count + 1));
                } else if (world[ny][nx] == 1 && currentLand != land[ny][nx]) {
                    return now.count;
                }
            }
        }
        return Integer.MAX_VALUE;
    }



    public static void checkLand() {
        int num = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(world[i][j] == 1 && land[i][j] == 0){
                    num++;
                    dfs(i, j, num);
                }
            }
        }
    }

    public static void dfs(int y, int x, int num) {
        land[y][x] = num;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                if (land[ny][nx] == 0 && world[ny][nx] > 0) {
                    land[ny][nx] = num;
                    dfs(ny, nx, num);
                }
            }
        }
    }
    public static class Position{
        int x;
        int y;
        int count;

        public Position(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}
