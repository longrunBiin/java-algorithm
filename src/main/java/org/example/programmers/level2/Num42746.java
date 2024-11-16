package org.example.programmers.level2;

import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String[] arr = new String[numbers.length];
        for(int i=0; i<numbers.length; i++) arr[i] = Integer.toString(numbers[i]);

        Arrays.sort(arr, (o1, o2) -> -(o1+o2).compareTo(o2+o1));

        String answer = "";
        for(String str : arr) answer += str;
        if(answer.charAt(0) == '0') answer = "0";

        return answer;
    }
}