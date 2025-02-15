package org.example.programmers.level2;

import java.util.*;
public class Num12973 {
    class Solution
    {
        public int solution(String s)
        {
            Stack<Character> stack = new Stack<>();

            for(int i=0;i<s.length();i++){
                char c = s.charAt(i);
                if(!stack.isEmpty()&&  c == stack.peek()){
                    stack.pop();
                }else{
                    stack.push(c);
                }

            }
            if(stack.isEmpty()) return 1;
            else return 0;
        }
    }
}
