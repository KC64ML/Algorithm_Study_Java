package 메이즈_러너;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution3 {

    private static int N;

    private static int[][] deepCopy(int[][] arr) {
        int[][] testCase = new int[arr.length][arr[0].length];

        for (int i = 0; i < arr.length; i++) {
            testCase[i] = arr[i].clone();
        }

        return testCase;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int[][] arr = new int[N][N];

        int startX = Integer.parseInt(tokenizer.nextToken());
        int startY = Integer.parseInt(tokenizer.nextToken());
        int endX = Integer.parseInt(tokenizer.nextToken());
        int endY = Integer.parseInt(tokenizer.nextToken());

        int count = 0;
        for (int i = startY; i < endY + 1; i++) {
            for (int j = startX; j < endX + 1; j++) {
                arr[i][j] = ++count;
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
        System.out.println();


        int squareLen = Math.max(Math.abs(endX - startX), Math.abs(endY - startY)) + 1;

        int[][] testCase = new int[squareLen][squareLen];
        for (int i = startY; i < startY + squareLen; i++) {
            for (int j = startX; j < startX + squareLen; j++) {
                testCase[i - startY][j - startX] = arr[i][j];
            }
        }

        int[][] testCase2 = deepCopy(testCase);

        // 회전
        for (int i = 0; i < squareLen; i++) {
            for (int j = 0; j < squareLen; j++) {
                testCase[i][j] = testCase2[squareLen - j - 1][i];
            }
        }

        for (int i = startY; i < startY + squareLen; i++) {
            for (int j = startX; j < startX + squareLen; j++) {
                arr[i][j] = testCase[i - startY][j - startX];
            }
        }


        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }

    }
}
