package 메이즈_러너;

import java.util.*;
import java.io.*;

public class Solution2 {

    private static int N, M, R;
    private static int[][] arr;
    private static int maxIndex;
    private static int[] operator;

    private static int swap(int a, int b){
        return a;
    }
    private static int[][] deepCopy(){
        int[][] testCase = new int[maxIndex][maxIndex];

        for(int i = 0; i < N; i++){
            testCase[i] = arr[i].clone();
        }

        return testCase;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());
        R = Integer.parseInt(tokenizer.nextToken());

        maxIndex = Math.max(N, M);
        arr = new int[maxIndex][maxIndex];

        for(int i = 0; i < N; i++){
            tokenizer = new StringTokenizer(reader.readLine());
            for(int j = 0; j < M; j++){
                arr[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        tokenizer = new StringTokenizer(reader.readLine());
        int tokenCnt = tokenizer.countTokens();
        operator = new int[tokenCnt];
        for(int i = 0; i < tokenCnt; i++) {
            operator[i] = Integer.parseInt(tokenizer.nextToken());
        }

        for(int i = 0; i < tokenCnt; i++){
            int[][] testCase = deepCopy();
            switch(operator[i]){
                case 1:
                    // 상하반전
                    for(int row = 0; row < N / 2; row++){
                        for(int col = 0; col < M; col++){
                            arr[N - row - 1][col] = swap(arr[row][col],arr[row][col] = arr[N - row - 1][col]);
                        }
                    }
                    break;
                case 2:
                    // 좌우반전
                    for(int row = 0; row < N; row++){
                        for(int col = 0; col < M / 2; col++){
                            arr[row][M - col - 1] = swap(arr[row][col], arr[row][col] = arr[row][M - col - 1]);
                        }
                    }
                    break;
                case 3:
                    // 90도 오른쪽 회전
                    M = swap(N , N = M);
                    for (int row = 0; row < N; row++) {
                        for (int col = 0; col < M; col++) {
                            arr[row][col] = testCase[M - col - 1][row];
                        }
                    }
                    break;
                case 4:
                    // 90도 왼쪽 회전
                    for(int row = 0; row < N; row++){
                        for(int col = 0; col < M; col++){
                            arr[M - col - 1][row] = testCase[row][col];
                        }
                    }
                    M = swap(N, N = M);
                    break;
                case 5:
                    // 1 -> 2, 2 -> 3, 3 -> 4, 4 -> 1
                    for(int row = 0; row < N / 2; row++){
                        for(int col = 0; col < M / 2; col++){
                            arr[row][col + M / 2] = testCase[row][col];
                            arr[row + N / 2][col + M / 2] = testCase[row][col + M / 2];
                            arr[row + N / 2][col] = testCase[row + N / 2][col + M /2];
                            arr[row][col] = testCase[row + N / 2][col];
                        }
                    }
                    break;
                case 6:
                    // 1 -> 4, 4 -> 3, 3 -> 2, 2 -> 1
                    for(int row = 0; row < N / 2; row++){
                        for(int col = 0; col < M / 2; col++){
                            arr[row + N / 2][col] = testCase[row][col];
                            arr[row + N / 2][col + M / 2] = testCase[row + N / 2][col];
                            arr[row][col + M / 2] = testCase[row + N / 2][col + M / 2];
                            arr[row][col] = testCase[row][col + M / 2];
                        }
                    }

                    break;
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        reader.close();
    }
}
