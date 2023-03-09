package Baekjoon.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ5073 {
    static String[] s = {"Equilateral", "Isosceles", "Scalene"};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while(true){
             st = new StringTokenizer(br.readLine());
            int firstData = Integer.parseInt(st.nextToken());
            int secondData = Integer.parseInt(st.nextToken());
            int thirdData = Integer.parseInt(st.nextToken());

            if(firstData == 0 && secondData == 0 && thirdData == 0){
                break;
            }else {
                int[] arr = {firstData, secondData, thirdData};
                Arrays.sort(arr);
                if(arr[0] + arr[1] <= arr[2]){
                    System.out.println("Invalid");
                }else if(firstData == secondData && secondData == thirdData){
                    System.out.println(s[0]);
                }else if(firstData == secondData || secondData == thirdData || firstData == thirdData){
                    System.out.println(s[1]);
                }else{
                    System.out.println(s[2]);
                }
            }
        }

        br.close();
    }
}
