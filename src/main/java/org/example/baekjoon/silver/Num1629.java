package org.example.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num1629 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        System.out.println(pow(a,b, c));
    }

    public static long pow(long a, long b, int c) {

        // 지수가 1일 경우 A^1 이므로 A를 그대로 리턴
        if(b == 1) {
            return a % c;
        }

        // 지수의 절반에 해당하는 A^(exponent / 2) 을 구한다.
        long temp = pow(a, b / 2, c);

        /*
         * 현재 지수가 홀 수 였다면
         * A^(exponent / 2) * A^(exponent / 2) * A 이므로
         * A를 한 번 더 곱해주어야 한다.
         *
         * ex) A^9 = A^4 * A^4 * A
         */
        if(b % 2 == 1) {
            return (temp * temp % c) * a % c;
        }
        return temp * temp % c;

    }

}
