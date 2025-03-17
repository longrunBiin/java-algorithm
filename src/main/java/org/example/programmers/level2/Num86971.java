package org.example.programmers.level2;

import java.util.*;
public class Num86971 {
    class Solution {
        static ArrayList<Integer>[] list;
        static int answer, N;
        static boolean[] visited;
        public int solution(int n, int[][] wires) {
            //양방향 그래프, 방문한 곳은 방문 X
            //wires의 원소를 순회하며 해당 원소를 제외한 네트워크 생성
            //방문한 곳과 안한곳의 차이를 리턴
            //차이 중 가장 작은것을 결과로
            N = n;
            answer = n-1;

            list= new ArrayList[n+1];

            for(int i=1;i<=n;i++){
                list[i] = new ArrayList<>();
            }

            for(int[] wire : wires){
                list[wire[0]].add(wire[1]);
                list[wire[1]].add(wire[0]);
            }


            visited = new boolean[n + 1];

            dfs(1);
            return answer;

        }
        private static int dfs(int now){
            visited[now] = true;
            int sum = 0;

            for(int next : list[now]){
                if(!visited[next]){
                    int cnt = dfs(next);
                    answer = Math.min(answer, Math.abs(N - cnt * 2));
                    sum+=cnt;
                }
            }
            return sum+1;
        }


    }
}
