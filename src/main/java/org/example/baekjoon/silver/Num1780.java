package org.example.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num1780 {
    static int N;
    static int[][] paper;
    static int one = 0;
    static int zero = 0;
    static int minusOne = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        paper = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        partition(0, 0, N);

        System.out.println(minusOne);	// -1
        System.out.println(zero);	// 0
        System.out.println(one);	// 1
    }

    public static void partition(int row, int col, int size) {

        // 만약 같은 색상으로 이루어져있다면 해당 색상 카운트를 증가시킨다.
        if (colorCheck(row, col, size)) {
            if(paper[row][col] == -1) {
                minusOne++;
            }
            else if(paper[row][col] == 0) {
                zero++;
            }
            else {
                one++;
            }

            return;
        }

        int newSize = size / 3;

        partition(row, col, newSize);								// 왼쪽 위
        partition(row, col + newSize, newSize);						// 중앙 위
        partition(row, col + 2 * newSize, newSize);					// 오른쪽 위

        partition(row + newSize, col, newSize);						// 왼쪽 중간
        partition(row + newSize, col + newSize, newSize);			// 중앙 중간
        partition(row + newSize, col + 2 * newSize, newSize);		// 오른쪽 중간

        partition(row + 2 * newSize, col, newSize);					// 왼쪽 아래
        partition(row + 2 * newSize, col + newSize, newSize);		// 중앙 아래
        partition(row + 2 * newSize, col + 2 * newSize, newSize);	// 오른쪽 아래

    }

    // 해당 영역이 같은 색인지 검사하는 메소드
    public static boolean colorCheck(int row, int col, int size) {
        int color = paper[row][col];

        // 각 블럭의 시작점(row, col)부터 블럭의 끝(row + size, col + size)까지 검사
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (color != paper[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
