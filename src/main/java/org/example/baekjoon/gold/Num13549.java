package org.example.baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Num13549 {
    static int N, K;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[100001];
        bfs(N);

        System.out.println(min);
    }

    static void bfs(int val){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(val, 0));
        visited[val] = true;

        while(!q.isEmpty()){
            Node current = q.poll();

            if(current.x == K)
                min = Math.min(min, current.time);

            if(current.x*2<=100000 && !visited[current.x*2]){
                q.offer(new Node(current.x*2, current.time));
                visited[current.x*2] = true;
            }

            if(current.x-1>=0 && !visited[current.x-1]){
                q.offer(new Node(current.x-1, current.time + 1));
                visited[current.x-1] = true;
            }

            if(current.x+1<=100_000 && !visited[current.x+1]){
                q.offer(new Node(current.x+1, current.time + 1));
                visited[current.x+1] = true;
            }
        }
    }
}
class Node {
    int x, time;

    Node(int x, int time) {
        this.x = x;
        this.time = time;
    }
}