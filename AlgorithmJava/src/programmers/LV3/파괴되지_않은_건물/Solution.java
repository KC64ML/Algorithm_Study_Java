package programmers.LV3.파괴되지_않은_건물;

import java.util.*;

class Solution {

    // 단순 반복문은 시간초과 발생
    public int solution(int[][] board, int[][] skills) {
        int[][] calculate = new int[board.length + 1][board[0].length + 1];

        for(int[] skill : skills){
            int type = (skill[0] == 1 ? -1 : 1);
            int r1 = skill[1];
            int c1 = skill[2];
            int r2 = skill[3];
            int c2 = skill[4];
            int degree = skill[5];

            // (1) 음수
            // - r1, c1은 음수 r1, c2 + 1은 양수
            // - r2, c1은 양수 r2, c2 + 1은 양수
            // 열을 돌리고 행을 돌리는 방식

            // type 양수 : 1, 음수 : -1

            calculate[r1][c1] += degree * (type);
            calculate[r1][c2 + 1] += degree * (type) * -1;
            calculate[r2 + 1][c1] += degree * (type) * -1;
            calculate[r2 + 1][c2 + 1] += degree * (type);
        }

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                calculate[i][j + 1] += calculate[i][j];
            }
        }

        for(int i = 0; i < board[0].length; i++){
            for(int j = 0; j < board.length; j++){
                calculate[j + 1][i] += calculate[j][i];
            }
        }

        int answer = 0;

        // System.out.println(Arrays.deepToString(calculate));
        // System.out.println();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] + calculate[i][j] > 0) answer++;
            }
        }

        return answer;
    }
}
