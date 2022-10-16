package Baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class test {

    static int N, K;
    static int[][] arr;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N][2];
        dp = new int[N][K + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) return o1[1] - o2[1];
                else return o1[0] - o2[0];
            }
        });

        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = arr[i][0]; j <= K; j++) {
                if (i == 0) {
                    dp[i][j] = arr[i][1];
                } else {
                    dp[i][j] = dp[i - 1][j];
                    if (j - arr[i][0] >= 0) {
                        dp[i][j] = Math.max(dp[i-1][j], dp[i - 1][j - arr[i][0]] + arr[i][1]);
                    }
                }

                if (answer < dp[i][j]) answer = dp[i][j];
            }
//            System.out.println(Arrays.toString(dp[i]));
        }

        StringBuilder sb = new StringBuilder();
//        System.out.println(Arrays.toString(dp[N-1]));

        sb.append(answer);
        System.out.println(sb);

        br.close();
    }
}


/*

5 104
3 90
103 89
2 87
99 86
98 85
262

이와 같은 이유로 바꿔야한다.

 */