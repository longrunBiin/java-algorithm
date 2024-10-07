package org.example.baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Num2206 {
    static int N, M;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];


        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - 48;
            }
        }

        bfs(new Pos(0,0, false, 1));
    }

    public static void bfs(Pos current) {
        Queue<Pos> q = new LinkedList<>();
        boolean[][][] visited = new boolean[N][M][2];
        q.add(current);

        while (!q.isEmpty()) {
            Pos now = q.poll();

            if (now.x == M - 1 && now.y == N - 1) {
                System.out.println(now.count);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue;

                int nextCount = now.count + 1;
                if (map[ny][nx] == 0) {
                    if (!now.isBreak && !visited[ny][nx][0]) {
                        q.add(new Pos(nx, ny, false, nextCount));
                        visited[ny][nx][0] = true;
                    } else if (now.isBreak && !visited[ny][nx][1]) {
                        q.add(new Pos(nx, ny, true, nextCount));
                        visited[ny][nx][1] = true;
                    }
                } else if (map[ny][nx] == 1) {
                    if (!now.isBreak) {
                        q.add(new Pos(nx, ny, true, nextCount));
                        visited[ny][nx][1] = true;
                    }
                }
            }
        }

        System.out.println("-1");
    }

    static class Pos{
        int x;
        int y;
        boolean isBreak;
        int count;
        public Pos(int x, int y, boolean isBreak, int count) {
            this.x = x;
            this.y = y;
            this.isBreak = isBreak;
            this.count = count;
        }
    }
}
