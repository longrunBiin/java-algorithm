package org.example.baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Num4179 {
    static int R, C;
    static char[][] board;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] fired;
    static int[][] jihun;

    static Queue<Pair> fireQueue = new LinkedList<>();
    static Queue<Pair> jihunQueue = new LinkedList<>();

    static class Pair{
        int x;
        int y;


        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        //입력 핼 R, 열 C
        R = Integer.parseInt(st1.nextToken());
        C = Integer.parseInt(st1.nextToken());
        board = new char[R][C];
        fired = new int[R][C];
        jihun = new int[R][C];

        for(int i = 0; i < R; i++) {
            Arrays.fill(fired[i], -1);
            Arrays.fill(jihun[i], -1);
        }

        for (int i = 0; i < R; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < C; j++) {
                board[i][j] = line[j].charAt(0);
                if(board[i][j]=='F') {
                    fired[i][j] = 0;
                    fireQueue.offer(new Pair(i, j));
                }
                if(board[i][j]=='J') {
                    jihunQueue.offer(new Pair(i,j));
                    jihun[i][j]=0;
                }
            }

        }

        int time = BFS();
        if (time == 0) System.out.println("IMPOSSIBLE");
        else System.out.println(time);

    }

    public static boolean isRange(int x, int y) {
        return x >= 0 && y >= 0 && x < R && y < C;
    }

    public static boolean isEdge(int x, int y) {
        return x == 0 || y == 0 || x == R - 1 || y == C - 1;
    }

    static public int BFS() {
        //불타는 위치를 구함

        while(!fireQueue.isEmpty()) {
            Pair current = fireQueue.remove();


            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if(!isRange(nx, ny) || board[nx][ny]=='#' || fired[nx][ny] != -1) continue;
                fireQueue.offer(new Pair(nx, ny));
                fired[nx][ny] = fired[current.x][current.y] + 1;


            }

        }
        while (!jihunQueue.isEmpty()) {
            Pair current = jihunQueue.remove();
            int time = jihun[current.x][current.y] + 1;
            if(isEdge(current.x, current.y)) return time;
            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if(!isRange(nx, ny) || board[nx][ny]== '#' || (fired[nx][ny] != -1 && fired[nx][ny] <= time) || jihun[nx][ny] != -1) continue;
                //불에 타지 않았으면 이동
                jihunQueue.offer(new Pair(nx, ny));
                //가장자리에 닿으면 성공
                jihun[nx][ny] = jihun[current.x][current.y] + 1;

            }
        }


        return 0;
    }
}
