package CodeUp;

import java.io.*;
import java.util.*;

public class CU1046 {
    public static void main(String[] args) throws Exception{
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer st = new StringTokenizer(br.readLine());
        final long[] arr = new long[st.countTokens()];

        for(int i =0 ; i<arr.length;i++){
            arr[i] = Long.parseLong(st.nextToken());
        }

        // 합
        long sum = Arrays.stream(arr).sum();

        // 평균
        float avg = (float)sum / 3;

        System.out.println(sum);
        System.out.printf("%.1f",avg);

        br.close();
    }
}
