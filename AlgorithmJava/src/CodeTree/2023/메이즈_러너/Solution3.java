package 메이즈_러너;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution3 {

    private static int N;

    private static int[][] deepCopy(int[][] arr){
        int[][] testCase = new int[arr.length][arr[0].length];

        for(int i = 0; i < arr.length ; i++){
            testCase[i] = arr[i].clone();
        }

        return testCase;
    }
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());
        int[][] arr = new int[N][N];

        int count = 0;
        for(int i = 0; i < N; i ++){
            for(int j = 0; j < N; j++){
                arr[i][j] = ++count;
            }
        }

        for(int i =0 ; i < N; i++){
            System.out.println(Arrays.toString(arr[i]));
        }
        int[][] testCase = deepCopy(arr);
        System.out.println();

        int startX = 1;
        int startY = 2;
        int endX = 4;
        int endY = 6;

        int squareLen = Math.max(Math.abs(endX - startX), Math.abs(endY - startY)) + 1;
        System.out.println(squareLen);

        for(int i = 0; i < squareLen; i++){
            for(int j = 0; j < squareLen; j++){
                System.out.println((i + startY) + ", " + (j + startX)  + " <= x : " + (squareLen - j + startX) + " y: " + (i + startY - 1));
                arr[i + startY][j + startX] = testCase[squareLen - j + startX][i + startY - 1];
            }
        }

        for(int i =0 ; i < N; i++){
            System.out.println(Arrays.toString(arr[i]));
        }

    }
}
