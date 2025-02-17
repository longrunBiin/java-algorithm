package org.example.programmers.level2;

public class Num42584 {
    class Solution {
        public int[] solution(int[] prices) {
            int[] answer = new int[prices.length];

            for(int i= 0; i< answer.length;i++){
                answer[i] = -1;
            }

            for(int i=0; i < prices.length;i++){
                int current = prices[i];
                int count = 0;
                for(int j = i+1; j < prices.length; j++){
                    if(current > prices[j]){
                        answer[i] = j - i;
                        break;
                    }else{
                        count++;
                    }

                }
                if(answer[i] == -1) answer[i] = count;
            }
            return answer;
        }
    }
}
