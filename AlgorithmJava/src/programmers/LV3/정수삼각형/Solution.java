package programmers.LV3.정수삼각형;

import java.util.Arrays;

public class Solution {

    private final int[][] mem = new int[501][501];

    public int max(int x, int y, int[][] triangle){
        // 마지막 라인에 도착했을 때 out
        if(y == triangle.length) return 0;
        if(mem[x][y] != -1) return mem[x][y];

        return mem[x][y] = triangle[y][x] + Math.max(max(x, y + 1, triangle), max(x +1, y+1,triangle));
    }

    public int solution(int[][] triangle) {
        for(int[] arr : mem){
            Arrays.fill(arr, -1);
        }

        return max(0, 0, triangle);
    }
}
