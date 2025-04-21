package org.example.programmers.level2;

public class Num12905 {
    class Solution
    {
        public int solution(int [][]board)
        {
            int row = board.length;
            int column = board[0].length;
            int max = board[0][0];

            for(int i=1; i< row; i++){
                for(int j = 1; j < column; j++){
                    if(board[i-1][j-1] >= 1 &&board[i-1][j] >= 1
                            &&board[i][j-1] >= 1 && board[i][j] >=1){
                        int min = Math.min(board[i-1][j-1], board[i-1][j]);
                        min = Math.min(min, board[i][j-1]);

                        board[i][j]+=min;
                        max = Math.max(max, board[i][j]);
                    }
                }
            }


            return max*max;
        }
    }
}
