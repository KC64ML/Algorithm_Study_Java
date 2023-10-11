package 포탑_부수기;

import java.io.*;
import java.util.*;

public class RotateClass {

    private static int[][] deepCopy(int[][] temp){
        int[][] testCase = new int[temp.length][temp[0].length];

        for(int i = 0; i < temp.length; i++){
            testCase[i] = temp[i].clone();
        }

        return testCase;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[][] arr = new int[n][n];
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int startY = Integer.parseInt(tokenizer.nextToken());
        int startX = Integer.parseInt(tokenizer.nextToken());

        int endY = Integer.parseInt(tokenizer.nextToken());
        int endX = Integer.parseInt(tokenizer.nextToken());

        int count = 0;
        for(int i = startY; i <= endY; i++){
            for(int j = startX; j <= endX; j++){
                arr[i][j] = ++count;
            }
        }
        for(int i = 0; i < n; i++){
            System.out.println(Arrays.toString(arr[i]));
        }

        System.out.println();

        int maxLen = Math.max(Math.abs(endY - startY + 1), Math.abs(endX - startX + 1));
        int[][] temp = new int[maxLen][maxLen];

        for(int i = startY; i <= endY; i++){
            for(int j = startX; j <= endX; j++){
                temp[i - startY][j -startX] = arr[i][j];
            }
        }

        int[][] testCase = deepCopy(temp);

        for(int i = 0; i < endY - startY + 1; i++){
            for(int j = 0; j < endX - startX + 1; j++){
                temp[maxLen - 1 - j][i] = testCase[i][j];
            }
        }

        for(int i = startY; i <= endY; i++){
            for(int j = startX; j <= endX; j++){
                arr[i][j] = temp[i - startY][j -startX];
            }
        }

        for(int i = 0; i < n; i++){
            System.out.println(Arrays.toString(arr[i]));
        }

    }
}

