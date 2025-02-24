package org.example.programmers.level1;

import java.util.*;
import java.util.stream.*;
public class Num12917 {
    class Solution {
        public String solution(String s) {

            return Arrays.stream(s.split("")).sorted(Comparator.reverseOrder())
                    .collect(Collectors.joining());
        }
    }
}
