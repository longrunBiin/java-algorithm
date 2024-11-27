package org.example.programmers.level2;
import java.util.*;
public class Num12909 {
    class Solution {
        boolean solution(String s) {
            boolean answer = true;
            Stack<Character> stack = new Stack<>();

            for(int i=0;i<s.length();i++){
                char c = s.charAt(i);

                if(stack.isEmpty()){
                    stack.push(c);
                }else if(c=='('&& stack.peek()=='('){
                    stack.push(c);
                }else if(c==')'&& stack.peek()=='('){
                    stack.pop();
                }else{
                    return false;
                }
            }

            if(!stack.isEmpty()){
                return false;
            }
            return answer;
        }
    }
}
