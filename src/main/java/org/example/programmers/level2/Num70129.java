package org.example.programmers.level2;

public class Num70129 {
    class Solution {
        public int[] solution(String s) {
            //0의 개수를 저장
            //1의 길이는 전체 길이 - 0이 길이
            //해당 길이를 2진수로 변환
            //반복 -> 변환값이 1일때 까지
            int zero = 0;
            int count = 0;
            while(!s.equals("1")){
                char[] array = s.toCharArray();
                int size = s.length();
                int curZero = 0;

                for(int i=0; i< size; i++){
                    int cur = Character.getNumericValue(array[i]);
                    if(cur == 0) curZero++;
                }

                int oneCount = size - curZero;
                s = Integer.toBinaryString(oneCount);

                zero += curZero;
                count++;
            }

            return new int[]{count, zero};
        }
    }
}
