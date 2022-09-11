package Baekjoon.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1326 {

    static int N;
    static int[] arr;
    static int[] dp;
    static boolean[] check;
    static int a, b;


    // 확인해야하는 곳 : https://bbeomgeun.tistory.com/45
    static void bfs(int x, int y){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(x);
        check[x] = true;
//
//        while (!q.empty()) {
//            int temp = q.front();
//            q.pop();
//
//            if (temp == to) {
//                return;
//            }
//
//            for (int i = temp + road[temp]; i <= N; i += road[temp]) {
//                if (!check[i]) {
//                    record[i] = record[temp] + 1;
//                    queue.push(i);
//                    check[i] = true;
//                }
//            }
//            for (int i = temp - road[temp]; i >=1; i -= road[temp]) {
//                if (!check[i]) {
//                    record[i] = record[temp] + 1;
//                    queue.push(i);
//                    check[i] = true;
//                }
//            }
//        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());


        bfs(a, b);

        br.close();
    }
}
