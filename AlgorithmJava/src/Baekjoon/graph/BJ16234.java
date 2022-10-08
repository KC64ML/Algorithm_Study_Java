package Baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ16234 {

    static int N, L, R;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());


        arr = new int[N][N];

        // 입력
        for(int i =0; i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0; j< N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 반복문을 돌리면서 확인한다.
        while(true){
            for(int i = 0; i< N;i++){
                for(int j = 0; j< N; j++){
//                    if()
                }
            }
        }

    }
}
