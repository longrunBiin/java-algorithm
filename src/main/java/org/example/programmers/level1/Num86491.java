package org.example.programmers.level1;

public class Num86491 {
    public static void main(String[] args) {

    }
    public int solution(int[][] sizes) {
        int answer = 0;
        int maxWidth = 0;
        int maxHeight = 0;
        for (int i = 0; i < sizes.length; i++) {
            if (sizes[i][0] < sizes[i][1]) {
                int temp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = temp;
            }

            maxWidth = Math.max(sizes[i][0], maxWidth);
            maxHeight = Math.max(sizes[i][1], maxHeight);
        }
        answer = maxHeight * maxWidth;
        return answer;
    }
}
