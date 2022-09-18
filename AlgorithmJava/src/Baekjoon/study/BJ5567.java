package Baekjoon.study;

import java.io.*;
import java.util.*;

public class BJ5567 {

    static int n;
    static int m;
    static List<Integer>[] list;
    static boolean[] visited;
    static int answer;

    static void bfs(int idx, int cnt) {

        Queue<Integer> queue = new ArrayDeque<>();


        // bfs로 변경해서 풀면 된다.
        queue.add(idx);
        if (cnt == 2) {
            System.out.println("idx : " + idx + " cnt : " + cnt);
            return;
        }


        for (int i = 0; i < list[idx].size(); i++) {
            if (list[idx].get(i) != 1 && !visited[list[idx].get(i)]) {
                System.out.println("시작 : " + idx + " " + list[idx].get(i));
                visited[list[idx].get(i)] = true;
                answer += 1;
                bfs(list[idx].get(i), cnt + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        list = new ArrayList[n + 1];

        StringTokenizer st;

        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
        }

        visited = new boolean[n + 1];
        bfs(1, 0);

        sb.append(answer);

        System.out.println(sb);

        br.close();
    }
}
