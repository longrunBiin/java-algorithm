package org.example.programmers.level3;

public class Num43162 {
    class Solution {
        public int solution(int n, int[][] computers) {
            //dfs로 0부터 시작해서 각 네트워크의 연결된 컴퓨터를 재귀로 순환
            //재귀에서 컴퓨터의 갯수만큼 검사하며 1이 더없으면 1개의 네트워크
            int answer = 0;
            boolean[] visited = new boolean[n];
            for(int i = 0; i< n; i++){
                if(!visited[i]){
                    dfs(visited, computers, i);
                    answer++;
                }
            }

            return answer;
        }
        public void dfs(boolean[] visited, int[][]computers, int i){
            visited[i] = true;
            for(int k = 0; k < computers.length; k++){
                if(computers[i][k] == 1 && !visited[k]){
                    dfs(visited, computers, k);
                }
            }
        }
    }
}
