package org.example.programmers.level2;

import java.util.*;
public class Num132265 {
    class Solution {
        public int solution(int[] topping) {
            //형과 동생의 갯수 배열을 생성
            //slice 별 종류를 Set에 담아  저장
            //형과 동생의 배열에서 인덱스가 같으면서 값이 같은 갯수를 구함
            int answer = 0;
            int[] oldArray = new int[topping.length -1];
            int[] youngArray = new int[topping.length -1];
            Set<Integer> old = new HashSet<>();
            Set<Integer> young = new HashSet<>();

            for(int i=0; i<oldArray.length;i++){
                old.add(topping[i]);
                oldArray[i] = old.size();
            }
            for(int i=youngArray.length; i>0;i--){
                young.add(topping[i]);
                youngArray[i-1] = young.size();
            }
            for(int i=0; i<oldArray.length;i++){
                if(oldArray[i] == youngArray[i])
                    answer++;
            }

            return answer;
        }
    }
}
