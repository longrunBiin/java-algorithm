package org.example.programmers.level2;

import java.util.*;
public class Num1844 {
    class Solution {
        int dx[] = {1,0,-1,0};
        int dy[] = {0,1,0,-1};
        boolean[][] visited;
        int n ;
        int m;

        public int solution(int[][] maps) {
            int answer = 0;
            n = maps.length;
            m = maps[0].length;
            visited = new boolean[n + 1][m + 1];

            return dfs(0,0,1,maps);
        }
        public int dfs(int x, int y, int count, int[][] maps){
            Queue<Position> queue = new ArrayDeque<>();
            queue.add(new Position(x,y, count));
            visited[y][x] = true;

            while(!queue.isEmpty()){
                Position current = queue.poll();

                for(int i=0;i<4;i++){
                    int nx = dx[i] + current.x;
                    int ny = dy[i] + current.y;

                    if(nx == m-1 && ny == n-1) return current.count + 1;
                    if(nx< 0 || ny < 0 || nx >= m || ny >=n) continue;

                    if(!visited[ny][nx] && maps[ny][nx] == 1){
                        visited[ny][nx] = true;
                        queue.add(new Position(nx,ny, current.count+1));
                    }
                }

            }
            return -1;
        }

        public class Position{
            int x, y, count;
            public Position(int x, int y, int count){
                this.x = x;
                this.y = y;
                this.count = count;
            }
        }
    }
}
