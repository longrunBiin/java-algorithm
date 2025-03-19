package org.example.programmers.level2;

public class Num87946 {
    class Solution {
        static int K, answer;
        static int[][] Dungeons;
        static boolean[] visited;
        public int solution(int k, int[][] dungeons) {
            //for문에서 재귀를 하면서 이전 인덱스를 함께 전송
            //이전 인덱스인 경우 continue, 아닌 경우 재귀
            //결과가 던전 수랑 같다면 return;
            //최소 필요 피로도가 k보다 크다면 리턴
            answer = 0;
            Dungeons = dungeons;

            visited = new boolean[dungeons.length];

            dfs(k,0);
            return answer;
        }
        public void dfs(int k, int cnt){
            for(int i=0;i<Dungeons.length;i++){
                if(!visited[i]&& k >=Dungeons[i][0]){
                    visited[i] = true;
                    dfs(k-Dungeons[i][1], cnt+1);
                    answer = Math.max(answer, cnt+1);
                    visited[i] = false;
                }
            }
        }
    }
}
