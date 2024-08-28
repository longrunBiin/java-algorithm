package org.example.baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Num15683 {

    static int N, M;
    static int[][] room;
    static ArrayList<Coordinate> cctvs;
    static int[] dx = {0, 1, 0, -1}; // 우, 하, 좌, 상
    static int[] dy = {1, 0, -1, 0};
    static int minBlindSpot = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        room = new int[N][M];
        cctvs = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
                if (room[i][j] >= 1 && room[i][j] <= 5) {
                    cctvs.add(new Coordinate(i, j, room[i][j]));
                }
            }
        }

        dfs(0, room);
        System.out.println(minBlindSpot);
    }

    public static void dfs(int idx, int[][] map) {
        if (idx == cctvs.size()) {
            minBlindSpot = Math.min(minBlindSpot, countBlindSpots(map));
            return;
        }

        Coordinate cctv = cctvs.get(idx);
        int[][] copiedMap;

        for (int i = 0; i < 4; i++) {
            copiedMap = copyMap(map);
            monitor(cctv, copiedMap, i);
            dfs(idx + 1, copiedMap);
            if (cctv.cctvNum == 5 || (cctv.cctvNum == 2 && i == 1)) break;
        }
    }

    public static void monitor(Coordinate cctv, int[][] map, int dir) {
        int type = cctv.cctvNum;

        for (int i = 0; i < 4; i++) {
            if ((type == 1 && i != dir) ||
                    (type == 2 && i % 2 != dir) ||
                    (type == 3 && i != dir && i != (dir + 1) % 4) ||
                    (type == 4 && i == dir)) continue;

            int nx = cctv.x;
            int ny = cctv.y;

            while (true) {
                nx += dx[i];
                ny += dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] == 6) break;
                if (map[nx][ny] == 0) map[nx][ny] = 9;
            }
        }
    }

    public static int countBlindSpots(int[][] map) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) count++;
            }
        }
        return count;
    }

    public static int[][] copyMap(int[][] map) {
        int[][] newMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            System.arraycopy(map[i], 0, newMap[i], 0, M);
        }
        return newMap;
    }

    public static class Coordinate {
        int x, y, cctvNum;

        public Coordinate(int x, int y, int cctvNum) {
            this.x = x;
            this.y = y;
            this.cctvNum = cctvNum;
        }
    }
}
