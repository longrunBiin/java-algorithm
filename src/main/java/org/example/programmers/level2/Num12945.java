package org.example.programmers.level2;

import java.util.*;
public class Num12945 {
    class Solution {
        public static final int MOD = 1234567;
        public int solution(int n) {
            int[] array = new int[100001];
            Arrays.fill(array, -1);  // 배열을 -1로 초기화
            array[0] = 0;  // 피보나치 0
            array[1] = 1;  // 피보나치 1

            for(int i=2 ; i<= n; i++){
                array[i] = mod(array[i-1] , array[i-2]);
            }

            return array[n];  // 피보나치 값 계산
        }
        public int mod(int i1, int i2){
            return ((i1 % MOD) + (i2 % MOD)) % MOD;
        }
    }
}
