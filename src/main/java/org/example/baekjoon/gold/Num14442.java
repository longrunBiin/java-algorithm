package org.example.baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Num14442 {
    static int N, M, K;
    static int[][] map;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        ;
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - 48;
            }
        }

        bfs(new Coordinate(0, 0, K, 0));
    }

    public static void bfs(Coordinate start) {
        Queue<Coordinate> q = new LinkedList<>();
        boolean[][][] visited = new boolean[N][M][K + 1];

        q.add(start);
        visited[start.y][start.x][start.isBreak] = true;
        while (!q.isEmpty()) {
            Coordinate current = q.poll();
            if (current.x == M - 1 && current.y == N - 1) {
                System.out.println(current.count + 1);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
                if (map[ny][nx] == 0 && !visited[ny][nx][current.isBreak]) {
                    q.add(new Coordinate(nx, ny, current.isBreak, current.count + 1));
                    visited[ny][nx][current.isBreak] = true;
                }
                if (current.isBreak > 0) {
                    if (map[ny][nx] == 1 && !visited[ny][nx][current.isBreak - 1]) {
                        q.add(new Coordinate(nx, ny, current.isBreak - 1, current.count + 1));
                        visited[ny][nx][current.isBreak - 1] = true;
                    }
                }
            }
        }
        System.out.println("-1");
    }

    public static class Coordinate {
        int x, y, isBreak, count;

        public Coordinate(int x, int y, int isBreak, int count) {
            this.x = x;
            this.y = y;
            this.isBreak = isBreak;
            this.count = count;
        }
    }

}
