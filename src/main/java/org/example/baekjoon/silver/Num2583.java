package org.example.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Num2583 {
    static int M,N,K;
    static int[][] board;

    static int[] dx = {0, 1, 0, -1, 0};
    static int[] dy = {0, 0, 1, 0, -1};
    static int[][] visited;
    static int count = 0;
    static ArrayList<Integer> weights = new ArrayList<>();
    static int weight = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st1.nextToken());
        N = Integer.parseInt(st1.nextToken());
        K = Integer.parseInt(st1.nextToken());

        board = new int[M][N];
        visited = new int[M][N];
//        initBoard();

        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            fillBoard(x1, y1, x2, y2);
        }
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 0 && visited[i][j] == 0){
                    weight = bfs(j, i);
                    count++;
                    weights.add(weight);
                    weight = 0;
                }
            }
        }
        System.out.println(count);
        weights.sort(Comparator.naturalOrder());
        for (Integer weight : weights) {
            System.out.print(weight + " ");
        }
    }

    private static int bfs(int x, int y) {
        for (int i = 0; i < 5; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < N && ny < M &&
                    board[ny][nx] == 0 && visited[ny][nx] == 0){
                visited[ny][nx] = 1;
                weight++;
                bfs(nx, ny);
            }
        }
        return weight;
    }

    private static void fillBoard(int x1, int y1, int x2, int y2) {
        for (int i = y1; i < y2; i++) {
            for (int j = x1; j < x2 ; j++) {
                if (board[i][j] != 1)
                    board[i][j] = 1;
            }
        }
    }

    private static void initBoard() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                board[N][M] = 0;
            }
        }
    }
    private static void initVisited() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[N][M] = 0;
            }
        }
    }
}
