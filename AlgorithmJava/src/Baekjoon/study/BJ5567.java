package Baekjoon.study;

import java.io.*;
import java.util.*;

public class BJ5567 {

    static int n;
    static int m;
    static List<Integer>[] list;
    static boolean[] visited;
    static int answer;

    // dfs를 통해 연결된 노드들을 다 확인한다.
    static void dfs(int idx, int cnt) {

        if (cnt == 2) {
            return;
        }

        // 방문한 곳을 다 체크해준다.
        for (int i = 0; i < list[idx].size(); i++) {
<<<<<<< HEAD
            if (list[idx].get(i) != 1 && !visited[list[idx].get(i)]) {
                System.out.println("시작 : " + idx + " " + list[idx].get(i));
                visited[list[idx].get(i)] = true;
                answer += 1;
                bfs(list[idx].get(i), cnt + 1);
            }
=======
            visited[list[idx].get(i)] = true;
            dfs(list[idx].get(i), cnt + 1);
>>>>>>> b8802effed903fa667a8aa3096685c5a3e19b3c9
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
            list[b].add(a);
        }

        visited = new boolean[n + 1];
        bfs(1, 0);

        // 현재 노드가 방문한 곳인지 확인한 후, answer += 1
        for (int i = 2; i <= n; i++) {
            if (visited[i]) answer++;
        }


        sb.append(answer);

        System.out.println(sb);

        br.close();
    }
}
