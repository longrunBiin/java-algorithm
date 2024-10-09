package org.example.baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Num1600 {
    static int K, W, H;
    static int[][] map;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[] hdx = {2, 1, -1, -2, -2, -1, 1, 2};
    static int[] hdy = {1, 2, 2, 1, -1, -2, -2, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H][W];
        for (int i = 0; i < H; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st2.nextToken());
            }
        }

        int count = bfs(new Coordinate(0, 0, 0, K));
        System.out.println(count);
    }

    public static int bfs(Coordinate start) {
        Queue<Coordinate> q = new LinkedList<>();
        boolean[][][] visited = new boolean[H][W][K+1];

        q.add(start);
        visited[start.y][start.x][K] = true;
        while (!q.isEmpty()) {
            Coordinate current = q.poll();
            if (current.x == W -1 && current.y == H - 1){
                return current.count;
            }

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= W || ny >= H) continue;
                if (!visited[ny][nx][current.isHorse] && map[ny][nx] == 0) {
                    visited[ny][nx][current.isHorse] = true;
                    q.add(new Coordinate(nx, ny, current.count + 1, current.isHorse));
                }

            }
            if (current.isHorse > 0) {
                for (int i = 0; i < 8; i++) {
                    int nx = current.x + hdx[i];
                    int ny = current.y + hdy[i];

                    if (nx < 0 || ny < 0 || nx >= W || ny >= H) continue;
                    if (!visited[ny][nx][current.isHorse - 1] && map[ny][nx] == 0){
                        visited[ny][nx][current.isHorse - 1] = true;
                        q.add(new Coordinate(nx, ny, current.count + 1, current.isHorse - 1));
                    }
                }
            }
        }

        return -1;
    }

}
class Coordinate{
    int x;
    int y;
    int count;
    int isHorse;

    public Coordinate(int x, int y, int count, int isHorse) {
        this.x = x;
        this.y = y;
        this.count = count;
        this.isHorse = isHorse;
    }
}
