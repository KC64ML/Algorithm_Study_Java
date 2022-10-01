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


//        bfs(a, b);

        br.close();
    }
}
