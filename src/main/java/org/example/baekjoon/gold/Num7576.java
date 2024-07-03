package org.example.baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Num7576 {
    static int M, N;
    static int[][] board;
    static Queue<int[]> queue;
    public static void main(String[] args) throws IOException {
        //가로 M 세로 N

        //입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st1.nextToken());
        N = Integer.parseInt(st1.nextToken());


        queue = new LinkedList<>();
        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] =  Integer.parseInt(st2.nextToken());
            }
        }
        //익은 토마토를 찾아서 인접한 위치를 큐에 삽입
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(board[i][j] == 1){
                    queue.add(new int[]{i, j});
                }
            }
        }
        //BFS를 돌며 총 날짜를 계산
        int count = BFS();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(board[i][j] == 0){
                    count = -1;
                }
            }
        }

        System.out.println(count);
    }
    public static int BFS() {
        int[] dx = new int[]{1,0,-1,0};
        int[] dy = new int[]{0, 1, 0, -1};
        int count = 0;

        while (!queue.isEmpty()) {
            count++;
            int size = queue.size();
            while (size > 0) {
                int[] current = queue.remove();
                for (int i = 0; i < 4; i++) {
                    int ny = current[0] + dx[i];
                    int nx = current[1] + dy[i];
                    if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
                    if (board[ny][nx] == -1) {
                        continue;
                    }
                    if (board[ny][nx] == 0) {
                        queue.add(new int[]{ny, nx});
                        board[ny][nx] = 1;

                    }
                }
                size--;
            }

        }


        return count-1;
    }
}
