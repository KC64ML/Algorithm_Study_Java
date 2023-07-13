package programmers.LV3.정수삼각형;

import java.util.Arrays;


public class Solution2 {

    private int[][] matrix = new int[501][501];

    private int move(int x, int y, int[][] triangle){


        // 0, 0
        if(y == triangle.length - 1) return triangle[y][x];

        if(matrix[y][x] != -1) return matrix[y][x];

        matrix[y][x] = triangle[y][x] + Math.max(move(x, y + 1, triangle), move(x + 1, y + 1, triangle));


        return matrix[y][x];
    }

    public int solution(int[][] triangle) {

        // -1로 초기화
        for(int[] inMatrix : matrix){
            Arrays.fill(inMatrix, -1);
        }

        return move(0, 0, triangle);
    }
}