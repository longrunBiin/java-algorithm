package org.example.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Num2178 {
    static int n, m;
    static int [][]visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] board;

    static public int BFS(int x, int y){
        visited[x][y] = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        while (!queue.isEmpty()) {
            int[] current = queue.remove();
            for (int i = 0; i < 4; i++) {
                int nx = current[0]+dx[i];
                int ny = current[1]+dy[i];
                if((nx>=0&&ny>=0&&nx<n&&ny<m) && visited[nx][ny] < 1 && board[nx][ny] == 1){
                    queue.add(new int[]{nx,ny});
                    visited[nx][ny] = visited[current[0]][current[1]] + 1;
                }

            }
        }
        return visited[n-1][m-1];
    }
    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        visited = new int[n][m];
        int distance = 0;

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = line.charAt(j) - '0';
            }
        }

        distance = BFS(0,0);

        System.out.println(distance);
    }



}
