package org.example.programmers.level2;

public class Num42842 {
    class Solution {
        public int[] solution(int brown, int yellow) {
            //노랑색 사각형 변의 길이 + 4 = 갈색 사각형 갯수
            //i*j == yellow인 수 중 i*2 + j*2 + 4 = brown
            //return i+2, j+2
            int[] answer = null;
            for(int i=1;i<=yellow;i++){
                for(int j=1;j<=yellow;j++){
                    if(i*j==yellow && (i*2) + (j*2)  + 4 == brown){
                        if(i+2 >= j+2)
                            return new int[]{i+2, j+2};
                        else
                            continue;
                    }
                }
            }
            return answer;
        }
    }
}
