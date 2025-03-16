package org.example.programmers.level2;
import java.util.*;

public class Num159993 {
    class Solution {
        static boolean visited[][];
        static char map[][];
        static int[] dx = {1,0,-1,0};
        static int[] dy = {0,1,0,-1};

        public int solution(String[] maps) {
            //1. 레버를 찾기위해 BFS를 하며 초를 센다.
            //2. 레버를 찾으면 출구를 찾기위한 BFS를 한다.
            //3. 두 경로의 걸린 시간을 더한다.

            visited = new boolean[maps.length][maps[0].length()];
            map = new char[maps.length][maps[0].length()];
            Position start = null, end = null, lever = null;
            for(int i=0; i< maps.length;i++){
                for(int j=0;j<maps[0].length();j++){
                    map[i][j] = maps[i].charAt(j);
                    if(map[i][j] == 'S') start = new Position(j,i,0);
                    else if(map[i][j] == 'E') end = new Position(j,i,0);
                    else if(map[i][j] == 'L') lever = new Position(j,i,0);
                }
            }

            int leverSec = bfs(start, lever);

            for(int i=0; i< visited.length;i++){
                for(int j=0;j<visited[0].length;j++){
                    visited[i][j] = false;
                }
            }

            int endSec = bfs(lever, end);

            if(leverSec == -1 || endSec == -1) return -1;
            return leverSec + endSec;
        }

        public int bfs(Position start, Position end){
            Queue<Position> queue = new ArrayDeque<>();
            visited[start.y][start.x] = true;
            queue.add(start);

            while(!queue.isEmpty()){
                Position current = queue.poll();
                if(current.x == end.x && current.y == end.y) {
                    return current.second;
                }
                for(int i=0; i<4;i++){
                    int nx = current.x + dx[i];
                    int ny = current.y + dy[i];

                    if(nx < 0 || ny < 0 || nx >= map[0].length || ny >= map.length) continue;
                    if(!visited[ny][nx] && map[ny][nx] != 'X'){
                        visited[ny][nx] = true;
                        queue.add(new Position(nx, ny, current.second + 1));

                    }
                }
            }

            return -1;
        }

        public class Position{
            public int x, y, second;
            public Position(int x, int y, int second){
                this.x = x;
                this.y = y;
                this.second = second;
            }
        }


    }
}
