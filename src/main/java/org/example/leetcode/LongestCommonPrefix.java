package org.example.leetcode;

public class LongestCommonPrefix {
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            String answer = "";
            int index = 0;
            int minLength = Integer.MAX_VALUE;
            for(int i=0; i< strs.length; i++){
                minLength = Math.min(minLength, strs[i].length());
            }
            while(index < minLength){
                char temp = strs[0].charAt(index);
                for(int i = 1; i < strs.length;i++){
                    if(strs[i].charAt(index) == temp){
                        continue;
                    }else return answer;
                }
                answer+=temp;
                index++;
            }
            return answer;
        }
    }
}
