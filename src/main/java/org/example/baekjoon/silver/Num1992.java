package org.example.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num1992 {
    static int N;
    static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = s.charAt(j) - '0';
            }
        }

        recur(0, 0, N);
    }

    public static void recur(int x, int y, int size) {
        if (size <= 0) return;
        if (check(x, y, size)){
            System.out.print(board[y][x]);
            return;
        }

        size /= 2;

        System.out.print("(");
        recur(x, y, size);
        recur(x + size, y, size);
        recur(x, y + size, size);
        recur(x + size, y + size, size);
        System.out.print(")");
    }

    public static boolean check(int x, int y, int size) {
        int color = board[y][x];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i + y][j + x] != color) return false;
            }
        }
        return true;
    }
}
