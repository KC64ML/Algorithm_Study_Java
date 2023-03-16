package Baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BJ2668 {

    static int N;
    static int[] arr;
    static boolean[] check;

    static boolean dfs(int start, int end){
        if(!check[start]) {
            check[start] = true;
            dfs(arr[start], end);
        }else{
            if(start == end) return true;
            else return false;
        }
        return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());


        arr = new int[N+1];

        for(int i =0 ; i< N; i++){
            int nextData = Integer.parseInt(br.readLine());

            arr[i] = nextData;
        }
        ArrayList<Integer> answerList  = new ArrayList<>();

        for(int i =1; i<= N; i++){
            check = new boolean[N + 1];
            if(dfs(i, i)){
                answerList.add(i);
            }
        }

        System.out.println(answerList.size());
        for (Integer integer : answerList) {
            System.out.println(integer);
        }

        br.close();
    }
}
