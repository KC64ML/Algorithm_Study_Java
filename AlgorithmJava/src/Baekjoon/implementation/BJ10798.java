package Baekjoon.implementation;

import java.util.*;
import java.io.*;

public class BJ10798 {
    public static void main(String[] args) throws IOException {
        // 배열 중 가장 긴 열 길이를 구한다.
        // 그걸 기준으로 돌린다.
        // 만약 해당 크기가 현재 열의 인덱스보다 작다면 패스한다.
        // 아니라면 입력한다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] arr_char = new char[5][];
        int num = 0;
        for (int i = 0; i < 5; i++) {
            String s = br.readLine();
            arr_char[i] = new char[s.length()];
            for (int j = 0; j < s.length(); j++) {
                arr_char[i][j] = s.charAt(j);
            }
            num = Math.max(num, arr_char[i].length);
        }

        String result = "";
        // 열로 반복문 돌린다.
        for (int i = 0; i < num; i++) {
            // 행으로 반복문 돌린다.
            for (int j = 0; j < 5; j++) {
                if (arr_char[j].length > i) {
                    result += arr_char[j][i];
                }
            }
        }

        System.out.println(result);
    }
}
