package org.example.programmers.level1;
import java.util.*;

public class Num64061 {
    public static void main(String[] args) {
        int solution = Solution.solution(
                new int[][]{{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}},
                new int[]{1, 5, 3, 5, 1, 2, 1, 4});
        System.out.println(solution);
        //4 3 1 1
    }
    static class Solution {
        public static int solution(int[][] board, int[] moves) {
            int answer = 0;
            ArrayList<Integer> box = new ArrayList<>();
            for(int i=0;i<moves.length;i++){
                int location = moves[i]-1;

                for(int j = 0; j< board.length;j++){
                    if(board[j][location] != 0){
                        box.add(board[j][location]);
                        board[j][location] = 0;

                        if(box.size() >= 2&&box.get(box.size()-1) == box.get(box.size()-2)){
                            answer+=2;
                            box.remove(box.size()-1);
                            box.remove(box.size()-1);
                        }
                        break;
                    }
                }
            }

            return answer;
        }
    }
}
