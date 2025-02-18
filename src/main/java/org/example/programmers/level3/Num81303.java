package org.example.programmers.level3;

import java.util.*;
public class Num81303 {
    public static void main(String[] args) {
        solution(8, 2, new String[]{"D 2","C","U 3","C","D 4","C","U 2","Z","Z"});
    }
    public static String solution(int n, int k, String[] cmd) {
        //리스트를 사용해서 뒤에서 제거하는 방식으로 사용
        //리스트에는 인덱스와 같은 값이 저장
        //U x = i + x, D x = i - x
        //삭제한 값은 다른 리스트에 저장된 후 복구 시 해당값을 인덱스 삼아 복구
        Stack<Integer> removed = new Stack<>();
        int[] up = new int[n+2];
        int[] down = new int[n+2];

        for(int i=0;i<n + 2; i++){
            up[i] = i-1;
            down[i] = i+1;
        }
        k++;

        for(int i=0;i<cmd.length;i++){
            if(cmd[i].startsWith("U")){
                String[] split = cmd[i].split(" ");
                int x = Integer.parseInt(split[1]);
                for(int j=0;j<x;j++)
                    k = up[k];

            }else if(cmd[i].startsWith("D")){
                String[] split = cmd[i].split(" ");
                int x = Integer.parseInt(split[1]);
                for(int j=0;j<x;j++)
                    k = down[k];
            }else if(cmd[i].equals("C")){
                removed.push(k);
                up[down[k]] = up[k];
                down[up[k]] = down[k];
                k = n < down[k] ?up[k] : down[k];
            }else{
                int r = removed.pop();
                down[up[r]] = r;
                up[down[r]] = r;

            }

        }

        char[]answer = new char[n];
        Arrays.fill(answer, 'O');

        for(int i : removed){
            answer[i - 1] = 'X';
        }

        return new String(answer);
    }
}
