package org.example.programmers.level0;

public class Num120861 {
    class Solution {
        public int[] solution(String[] keyinput, int[] board) {
            int[] answer = {};
            int minX = ((board[0]/2)* -1);
            int minY = ((board[1]/2) * -1);
            int maxX = board[0]/2;
            int maxY = board[1]/2;
            int currX = 0;
            int currY = 0;

            for(int i=0;i<keyinput.length;i++){
                String key = keyinput[i];
                switch(key){
                    case "left" : currX-=1; break;
                    case "right" : currX += 1; break;
                    case "up" : currY += 1; break;
                    case "down" : currY -=1; break;
                }
                if(currX < minX) currX = minX;
                else if(currX > maxX) currX = maxX;
                else if(currY < minY) currY = minY;
                else if(currY > maxY) currY = maxY;
            }
            return new int[]{currX, currY};
        }
    }
}
