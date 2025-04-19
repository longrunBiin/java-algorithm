package org.example.programmers.level1;

import java.util.*;
public class Num12932 {
    class Solution {
        public List<Long> solution(long n) {
            List<Long> list = new ArrayList<>();
            while(n != 0){
                list.add(n%10);
                n /= 10;
            }

            return list;
        }
    }
}
