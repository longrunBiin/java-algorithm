package org.example.baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num2447 {
    static int N;
    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());


        arr = new char[N][N];

        star(0, 0, N, false);
        for (int i = 0; i < N; i++) {
            System.out.print(arr[i]);
            System.out.println();
        }
    }

    static void star(int x, int y, int N, boolean blank) {

        // 공백칸일 경우
        if(blank) {
            for(int i = x; i < x + N; i++) {
                for(int j = y; j < y + N; j++) {
                    arr[i][j] = ' ';
                }
            }
            return;
        }

        // 더이상 쪼갤 수 없는 블록일 때
        if(N == 1) {
            arr[x][y] = '*';
            return;
        }




	/*
	N=27 일 경우 한 블록의 사이즈는 9이고,
	N=9 일 경우 한 블록의 사이즈는 3이듯
	해당 블록의 한 칸을 담을 변수를 의미 size

	count 는 별 출력 누적 합을 의미하는 변수다.
	*/

        int size = N/3;
        int count = 0;
        for(int i = x; i < x + N; i += size) {
            for(int j = y; j < y + N; j += size) {
                count++;
                if(count == 5) {	// 공백 칸일 경우
                    star(i, j, size, true);
                }
                else {
                    star(i, j, size, false);
                }
            }
        }
    }
}
