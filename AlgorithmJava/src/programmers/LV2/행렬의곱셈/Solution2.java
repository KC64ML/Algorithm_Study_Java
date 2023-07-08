package programmers.LV2.행렬의곱셈;

class Solution2 {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int matrixSize = arr1[0].length;
        int[][] answer = new int[arr1.length][arr2[0].length];
        for(int i = 0; i < arr1.length; i++){
            for(int j =0; j < arr2[0].length; j++){

                int matrix = 0;
                for(int k = 0; k < matrixSize; k++){
                    matrix += arr1[i][k] * arr2[k][j];
                }

                answer[i][j] = matrix;
            }
        }

        return answer;
    }
}
