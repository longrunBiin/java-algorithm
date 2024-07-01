package org.example.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Num1926 {
    public static void main(String[] args) throws IOException {
        //세로 n, 가로 m
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Queue<int[]> queue = new LinkedList<>();
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        int maxSize = 0;
        int area = 0;

        int[][] board = new int[n][m];
        int[][] visited = new int[n][m];
        for(int i=0;i<n;i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                board[i][j] = Integer.parseInt(st2.nextToken());
            }
        }
        for(int i=0;i<n;i++){
            for (int j = 0; j < m; j++) {
                int size = 0;
                if(board[i][j] == 1 && visited[i][j] != 1) {
                    visited[i][j]=1;
                    area++;
                    queue.add(new int[]{i, j});
                    while (!queue.isEmpty()) {
                        int[] cur = queue.remove();
                        size++;
                        for (int dir = 0; dir < 4; dir++) {
                            int nx = cur[0]+dx[dir];
                            int ny = cur[1]+dy[dir];
                            if ((nx >= 0 && ny >= 0 && nx < n && ny < m) && board[nx][ny] == 1 && visited[nx][ny] != 1) {
                                visited[nx][ny]=1;
                                queue.add(new int[]{nx,ny});
                            }
                        }
                    }

                    maxSize = Math.max(size, maxSize);

                }
            }
        }
        System.out.println(area);
        System.out.println(maxSize);
    }
}
