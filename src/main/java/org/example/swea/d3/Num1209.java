package org.example.swea.d3;

import java.util.Scanner;

class Num1209 {
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);

        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int n = sc.nextInt();
            int[][] array = new int[100][100];
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    array[i][j] = sc.nextInt();
                }
            }
            int maxRow = 0;
            int maxColumn = 0;
            int max = 0;
            for (int i = 0; i < 100; i++) {
                int sumColumn = 0;
                int sumRow = 0;
                for (int j = 0; j < 100; j++) {
                    sumRow += array[i][j];
                    sumColumn += array[j][i];
                }
                maxRow = Math.max(sumRow, maxRow);
                maxColumn = Math.max(sumColumn, maxColumn);
            }
            max = Math.max(maxRow, maxColumn);
            int sum = 0;
            for (int i = 0; i < 100; i++) {
                sum += array[i][i];
            }
            max = Math.max(sum, max);
            sum = 0;
            for (int i = 99; i >= 0; i--) {
                sum += array[i][i];
            }
            max = Math.max(sum, max);

            System.out.println("#"+n+" "+max);
        }
    }
}