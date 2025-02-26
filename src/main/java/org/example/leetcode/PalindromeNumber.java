package org.example.leetcode;
import java.util.*;

public class PalindromeNumber {
    static class Solution {
        public static void main(String[] args) {
            isPalindrome(121);
        }
        public static boolean isPalindrome(int x) {
            if(x < 0) return false;
            String s = String.valueOf(x);
            String front = s.substring(0, s.length()/2);
            String behind = "";
            if (s.length() % 2 == 1)
                behind = s.substring(s.length()/2+1);
            else
                behind = s.substring(s.length()/2);
            StringBuffer sb = new StringBuffer(behind);
            String reverse = sb.reverse().toString();
            return front.equals(reverse);
        }
    }
}
