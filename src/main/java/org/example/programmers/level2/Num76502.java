package org.example.programmers.level2;

import java.util.*;
public class Num76502 {
    class Solution {
        public int solution(String s) {
            int answer = 0;
            char[] c = s.toCharArray();

            A:for(int k = 0;k<s.length(); k++){
                Stack<Character> stack = new Stack<>();
                boolean flag = false;

                for(int i=k;i<s.length() + k;i++){
                    int index = i % s.length();
                    if(c[index]=='(' || c[index]== '{' || c[index]== '['){
                        stack.push(c[index]);
                        flag = true;
                    }
                    else{
                        if(stack.isEmpty()) continue A;

                        if(c[index]==')' && stack.pop() == '(') continue;
                        else if(c[index]=='}' && stack.pop() == '{') continue;
                        else if(c[index]==']' && stack.pop() == '[') continue;
                        else continue A;
                    }
                }
                if(stack.isEmpty() && flag) answer++;

            }

            return answer;
        }
    }
}
