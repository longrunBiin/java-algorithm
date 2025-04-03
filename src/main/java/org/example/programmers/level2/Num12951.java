package org.example.programmers.level2;

public class Num12951 {
    class Solution {
        public String solution(String s) {
            StringBuilder answer = new StringBuilder();
            boolean isFirst = true;  // 단어의 첫 글자인지 확인
            for (char c : s.toCharArray()) {
                if (c == ' ') {
                    answer.append(c);
                    isFirst = true;  // 공백 이후는 단어의 첫 글자
                } else {
                    if (isFirst) {
                        answer.append(Character.toUpperCase(c));
                    } else {
                        answer.append(Character.toLowerCase(c));
                    }
                    isFirst = false;
                }
            }
            return answer.toString();
        }
    }
}
