package org.example.baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Num6593 {

    static int L,R,C;
    static int[] dx= {-1,1,0,0,0,0};
    static int[] dy = {0,0,-1,1,0,0};
    static int[] dz = {0,0,0,0,1,-1};

    static Pos start, end;
    static char[][][] building;
    static boolean[][][] visited;
    public static class Pos{
        int x;
        int y;
        int z;
        int minute;

        public Pos(int x, int y, int z, int minute) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.minute = minute;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if (L==0&&R==0&&C==0) return;

            building = new char[L][R][C];

            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String s = br.readLine();
                    for (int k = 0; k < C; k++) {
                        building[i][j][k] = s.charAt(k);
                        if (building[i][j][k] == 'S') {
                            start = new Pos(k, j, i, 0);
                        }
                        if (building[i][j][k] == 'E') {
                            end = new Pos(k, j, i, 0);
                        }
                    }
                }
                br.readLine();
            }
            bfs(start);
            //
        }
    }

    public static void bfs(Pos current) {
        Queue<Pos> q = new LinkedList();
        visited = new boolean[L][R][C];

        q.add(current);
        visited[current.z][current.y][current.x] = true;

        while (!q.isEmpty()) {
            current = q.poll();
            if (current.x == end.x && current.y == end.y && current.z ==  end.z) {
                System.out.println("Escaped in " + current.minute + " minute(s).");
                return;
            }

            for (int i = 0; i < 6; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                int nz = current.z + dz[i];

                if (nx < 0 || ny < 0 || nz < 0 || nx >= C || ny >= R || nz >= L) continue;
                if (!visited[nz][ny][nx] && building[nz][ny][nx] != '#'){
                   visited[nz][ny][nx] = true;
                    q.add(new Pos(nx, ny, nz, current.minute + 1));
                }
            }
        }
        System.out.println("Trapped!");

    }
}
