package org.example.programmers.level2;

import java.util.*;
public class Num49994 {

    class Solution {
        static HashMap<Character, int[]> direction = new HashMap<>();

        public int solution(String dirs) {
            int x = 5, y = 5;
            init();

            HashSet<String> answer = new HashSet<>();

            for(int i=0;i<dirs.length();i++){
                int[] location = direction.get(dirs.charAt(i));
                int nx = x + location[0];
                int ny = y + location[1];
                if(!isValid(nx, ny)) continue;

                answer.add(x+" "+ y+ " "+ nx+ " "+ ny);
                answer.add(nx+" "+ ny+ " "+ x+ " "+ y);

                x = nx;
                y = ny;
            }

            return answer.size() / 2;
        }

        public static boolean isValid(int nx, int ny){
            return nx < 11 && ny < 11 && nx >= 0 && ny >= 0;
        }
        public static void init(){
            direction.put('U', new int[]{0,1});
            direction.put('D', new int[]{0,-1});
            direction.put('R', new int[]{1,0});
            direction.put('L', new int[]{-1,0});
        }
    }
}
