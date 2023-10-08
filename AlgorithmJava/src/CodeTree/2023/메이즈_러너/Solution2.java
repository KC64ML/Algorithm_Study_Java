package 메이즈_러너;

import java.util.*;

public class Solution2 {

    private static int[][] deepCopy(int[][] arr){

        int[][] nArr = new int[arr.length][arr[0].length];
        for(int i = 0; i < arr.length; i++){
            nArr[i] = arr[i].clone();
        }

        return nArr;
    }

    public static void main(String[] args) {
        int[][] arr = new int[6][4];
        int m = 4;
        int n = 6;
        int count = 0;
        for(int i =0 ; i < n; i++){
            for(int j = 0; j< m; j++){
                arr[i][j] = ++count;
            }
        }
        int[][] testcase = deepCopy(arr);
//        for (int i = 0; i < 5; i++) {
//            for (int j = 0; j < 5; j++) {
//                System.out.println("i, j : " + i + " " + j + " : " + (5-j-1) + ", " + i);
//                arr[i][j] = testcase[5 - j - 1][i];
//            }
//        }

        for(int i = 0 ; i < n; i++){
            System.out.println(Arrays.toString(arr[i]));
        }

        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < m / 2; j++) {
                arr[i][j] = testcase[i][m / 2 + j];
                arr[n / 2 + i][j] = testcase[i][j];
                arr[n / 2 + i][m / 2 + j] = testcase[n / 2 + i][j];
                arr[i][m / 2 + j] = testcase[n / 2 + i][m / 2 + j];


            }
        }

        System.out.println();
        for(int i = 0 ; i < n; i++){
            System.out.println(Arrays.toString(arr[i]));
        }
    }
}
