package org.example.baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Num2573 {
    static int N, M;
    static int[][] map, copied;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        copied = new int[N][M];
        Position start = null;
        for (int i = 0; i < N; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st2.nextToken());
                copied[i][j] = map[i][j];
                if (start == null && map[i][j] != 0) {
                }
            }
        }

        int year = 0;
        while (true) {
            int result = countIsland();

            // 빙산 덩어리가 0개(다 녹은 경우)이거나, 2개 이상일 경우 break
            if (result >= 2) {
                break;
            } else if (result == 0) {
                year = 0; // 빙산이 다 녹을 때까지 두 덩어리 이상 분리되지 않는 경우이므로 0을 넣어줌
                break;
            }

            bfs();
            year++;
        }
        System.out.println(year);
    }
    public static void bfs() {
        Queue<Position> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > 0) {
                    q.add(new Position(i, j));
                    visited[i][j] = true;
                }
            }
        }

        while (!q.isEmpty()) {
            Position ice = q.poll();

            int sea = 0; // 빙산 상하좌우에 존재하는 바닷물 영역의 개수

            for (int i = 0; i < 4; i++) {
                int nx = ice.x + dx[i];
                int ny = ice.y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (!visited[nx][ny] && map[nx][ny] == 0) {
                        sea++;
                    }
                }
            }

            if (map[ice.x][ice.y] - sea < 0) {
                map[ice.x][ice.y] = 0; // 각 칸에 저장된 높이는 0보다 더 줄어들지 않기 때문에 0보다 작아지는 경우 0을 저장
            } else {
                map[ice.x][ice.y] -= sea;
            }
        }
    }

    public static int countIsland() {
        boolean[][] visited = new boolean[N][M];

        int cnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && map[i][j] > 0) {
                    dfs(i, j, visited);
                    cnt++;
                }
            }
        }

        return cnt;
    }

    // dfs를 통해 빙산 덩어리를 계산
    public static void dfs(int x, int y, boolean[][] visited) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                if (!visited[nx][ny] && map[nx][ny] > 0) {
                    dfs(nx, ny, visited);
                }
            }
        }
    }
    public static class Position{
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
