package org.example.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Num5014 {

    static int F, S, G, U, D;
    static int count = 0;
    static int[] dir, move;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        dir = new int[]{U, -D};
        move = new int[F + 1];

        bfs(S);

    }

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] arr = new boolean[F + 1];

        queue.add(start);
        arr[start] = true;
        move[start] = 0;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (current == G) {
                System.out.println(move[current]);
                return;
            }

            for (int i = 0; i < 2; i++) {
                int next = current + dir[i];
                if(next > F || next < 1 ) continue;

                if(!arr[next]) {
                    arr[next] = true;
                    queue.add(next);
                    move[next]= move[current]+1;
                }
            }
        }
        System.out.println("use the stairs");
    }

}
