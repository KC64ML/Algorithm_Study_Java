package programmers.LV3.등굣길;

import java.util.Arrays;

public class Solution2 {

    private int m, n;
    private int[][] matrix = new int[101][101];

    private boolean isWithIn(int x, int y){
        return 0 <= x && 0 <= y && x < m && y < n;
    }

    private int count(int x, int y){
        if(!isWithIn(x, y) || matrix[y][x] == -100) return 0;

        if(x == m - 1 && y == n - 1) return 1;

        if(matrix[y][x] != -1) return matrix[y][x];

        matrix[y][x] = (count(x, y + 1) + count(x + 1, y)) % 1000000007;
        // System.out.println("x, y : " + x + " " + y + " : " + matrix[y][x]);
        return matrix[y][x];
    }

    public int solution(int _m, int _n, int[][] puddles) {


        for(int[] inMatrix : matrix){
            Arrays.fill(inMatrix, -1);
        }

        for(int[] inPuddle : puddles){
            int x = inPuddle[0];
            int y = inPuddle[1];

            matrix[y - 1][x - 1] = -100;
        }

        m = _m;
        n = _n;

        return count(0, 0);
    }
}
