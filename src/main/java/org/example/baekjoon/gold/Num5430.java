package org.example.baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Num5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String array = br.readLine();

            // 입력 배열을 deque로 변환
            ArrayDeque<Integer> numbers = toIntArray(array);
            boolean flag = true;  // 덱의 앞/뒤 처리 방향을 추적하는 플래그
            boolean error = false;  // 에러 발생 여부

            // 명령어 처리
            for (char command : p.toCharArray()) {
                if (command == 'R') {
                    flag = !flag;  // 배열의 순서를 뒤집지 않고 플래그만 반전
                } else if (command == 'D') {
                    if (numbers.isEmpty()) {
                        error = true;
                        break;
                    }
                    if (flag) {
                        numbers.pollFirst();  // 앞에서 제거
                    } else {
                        numbers.pollLast();  // 뒤에서 제거
                    }
                }
            }

            if (error) {
                System.out.println("error");
            } else {
                printArray(numbers, flag);
            }
        }
    }

    // 입력 배열을 deque로 변환하는 메소드
    private static ArrayDeque<Integer> toIntArray(String array) {
        ArrayDeque<Integer> numbers = new ArrayDeque<>();
        array = array.substring(1, array.length() - 1);  // 대괄호 제거
        if (!array.isEmpty()) {  // 빈 배열이 아닌 경우
            String[] stringNumbers = array.split(",");
            for (String strNum : stringNumbers) {
                numbers.add(Integer.parseInt(strNum.trim()));  // 숫자 추가
            }
        }
        return numbers;
    }

    // deque를 문제에서 요구한 형식으로 출력하는 메소드
    private static void printArray(ArrayDeque<Integer> numbers, boolean flag) {
        StringBuilder sb = new StringBuilder("[");
        while (!numbers.isEmpty()) {
            if (flag) {
                sb.append(numbers.pollFirst());
            } else {
                sb.append(numbers.pollLast());
            }
            if (!numbers.isEmpty()) {
                sb.append(",");
            }
        }
        sb.append("]");
        System.out.println(sb);
    }
}
