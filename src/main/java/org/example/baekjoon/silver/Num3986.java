package org.example.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Num3986 {
    static int count = 0;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            Stack<String> stack = new Stack<>();
            for (int j = 0; j < s.length(); j++) {
                String firstChar = s.substring(j, j + 1);

                if (!firstChar.equals("A") && !firstChar.equals("B")) break;
                if (stack.isEmpty()) {
                    stack.push(firstChar);
                    continue;
                }

                String top = stack.peek();
                if (top.equals(firstChar)){
                    stack.pop();
                }
                else {
                    stack.push(firstChar);
                }
            }
            if (stack.isEmpty()) count++;
        }
        System.out.println(count);
    }
}
