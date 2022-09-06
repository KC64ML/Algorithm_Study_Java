package Baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1326 {

    static int N;
    static int[] arr;
    static boolean[] check;
    static int[] res;
    static int a, b;


    static void bfs(int from, int to) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(from);
        check[from] = true;

        while (queue.size() > 0) {
            int temp = queue.poll();

            if (temp == to) return;

            // 오른쪽 방향으로 확인한다.
            for (int i = temp + arr[temp]; i <= N; i += arr[temp]) {
                if (!check[i]) {
                    check[i] = true;
                    res[i] = res[temp] + 1;
                    queue.add(i);
                }
            }


            // 왼쪽 방향으로 확인한다.
            for (int i = temp - arr[temp]; i >= 1; i -= arr[temp]) {
                if (!check[i]) {
                    check[i] = true;
                    res[i] = res[temp] + 1;
                    queue.add(i);
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[N + 1];
        res = new int[N + 1];

        // 각 인덱스 크기
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        check = new boolean[N + 1];


        bfs(a, b);
        sb.append(res[b]);

        if (res[b] == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sb);
        }

        br.close();
    }
}
