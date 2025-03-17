package org.example.programmers.level2;

import java.util.*;
public class Num12978 {
    class Solution {
        static int[] village;
        public int solution(int N, int[][] road, int K) {
            //1번에서 다른 마을로 가는 최단 경로를 저장하는 배열을 가짐
            //1번부터 갈수 있는 마을을 BFS
            ArrayList<Node>[] adjList = new ArrayList[N+1];
            for(int i=1;i<= N; i++){
                adjList[i] = new ArrayList<>();
            }

            for(int[] edge : road){
                adjList[edge[0]].add(new Node(edge[1], edge[2]));
                adjList[edge[1]].add(new Node(edge[0], edge[2]));
            }

            int[]dist = new int[N+1];
            Arrays.fill(dist, Integer.MAX_VALUE);

            PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
            pq.add(new Node(1,0));
            dist[1] = 0;

            while(!pq.isEmpty()){
                Node now = pq.poll();

                if(dist[now.dest]<now.cost) continue;

                for(Node next : adjList[now.dest]){
                    if(dist[next.dest] > now.cost + next.cost){
                        dist[next.dest] = now.cost + next.cost;
                        pq.add(new Node(next.dest, dist[next.dest]));
                    }
                }
            }

            int answer = 0;
            for(int i=1; i<=N; i++){
                if(dist[i] <= K) answer++;
            }

            return answer;
        }

        public class Node{
            int dest;
            int cost;
            public Node(int dest, int cost){
                this.dest = dest;
                this.cost = cost;
            }
        }
    }
}
