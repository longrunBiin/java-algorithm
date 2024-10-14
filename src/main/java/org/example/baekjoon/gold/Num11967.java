package org.example.baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Num11967 {
    static int N, M;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] room;  // 불이 켜졌는지 여부
    static boolean[][] visited;  // 방문했는지 여부
    static ArrayList<Light>[][] switches;  // 각 방에 달린 스위치
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        room = new boolean[N][N];
        visited = new boolean[N][N];
        switches = new ArrayList[N][N];

        // 각 방의 스위치를 초기화
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                switches[i][j] = new ArrayList<>();
            }
        }

        // 스위치 정보를 입력받아 각 방에 저장
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            switches[x][y].add(new Light(a, b));
        }

        bfs();
        int count = 0;
        // 켜진 방의 개수 세기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (room[i][j]) count++;
            }
        }
        System.out.println(count);
    }

    public static void bfs() {
        Queue<Node> q = new LinkedList<>();
        room[0][0] = true;  // (0,0) 방의 불을 켬
        visited[0][0] = true;  // (0,0) 방을 방문함
        q.add(new Node(0, 0));

        while (!q.isEmpty()) {
            Node current = q.poll();

            // 현재 방에서 불을 켤 수 있는 방들의 불을 켠다
            for (Light light : switches[current.x][current.y]) {
                if (!room[light.x][light.y]) {  // 불이 꺼져있다면 켠다
                    room[light.x][light.y] = true;

                    // 만약 켠 방이 아직 방문되지 않은 방이고, 인접한 곳에 있는 경우 큐에 추가
                    if (isAdjacentVisited(light.x, light.y)) {
                        visited[light.x][light.y] = true;
                        q.add(new Node(light.x, light.y));
                    }
                }
            }

            // 상하좌우로 이동하면서 탐색
            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;  // 범위 벗어남
                if (!visited[nx][ny] && room[nx][ny]) {  // 방문하지 않은 불 켜진 방으로 이동
                    visited[nx][ny] = true;
                    q.add(new Node(nx, ny));
                }
            }
        }
    }

    // 방 (x, y)와 인접한 곳에 방문한 방이 있는지 확인하는 함수
    public static boolean isAdjacentVisited(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < N && ny < N && visited[nx][ny]) {
                return true;
            }
        }
        return false;
    }

    public static class Node {
        int x, y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static class Light {
        int x, y;
        public Light(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
