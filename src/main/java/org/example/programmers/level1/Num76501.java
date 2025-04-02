package org.example.programmers.level1;

public class Num76501 {
    class Solution {
        public int solution(int[] absolutes, boolean[] signs) {
            int answer = 0;
            for(int i=0;i<signs.length;i++){
                if(signs[i]){
                    answer += absolutes[i];
                }else{
                    answer -= absolutes[i];
                }
            }
            return answer;
        }
    }
}
