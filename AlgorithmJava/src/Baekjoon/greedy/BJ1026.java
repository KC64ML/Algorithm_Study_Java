package Baekjoon.greedy;

import java.util.*;
import java.io.*;

public class BJ1026 {

    private static int N;
    private static int[] arr1, arr2;

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(reader.readLine());

        arr1 = new int[N];
        arr2 = new int[N];

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        for(int i = 0; i < N; i++){
            arr1[i] = Integer.parseInt(tokenizer.nextToken());
        }

        tokenizer = new StringTokenizer(reader.readLine());

        for(int i = 0; i < N; i++){
            arr2[i] = Integer.parseInt(tokenizer.nextToken());
        }


        Arrays.sort(arr1);
        arr2 = Arrays.stream(arr2).boxed().sorted((a, b) -> b - a).mapToInt(Integer::intValue).toArray();

        int answer = 0;
        for(int i = 0; i < N; i++){
            answer += (arr1[i] * arr2[i]);
        }

        System.out.println(answer);

        reader.close();
    }
}
