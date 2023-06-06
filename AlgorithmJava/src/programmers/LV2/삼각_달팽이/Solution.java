package programmers.LV2.삼각_달팽이;

public class Solution {
    public int[] solution(int n) {
        int[][] triangle = new int[n][n];
        int v = 1;
        int x = 0;
        int y = 0;

        while (true) {
            // 아래로 이동
            while (true) {
                triangle[y][x] = v++;

                // 다음 번째 y축 값이 n이거나, 이미 방문한 곳이라면 break;
                if (y + 1 == n || triangle[y + 1][x] != 0) break;
                y += 1;
            }


            // 우측 방향이 n이거나, 이미 방문한 곳이라면 더 이상 갈 곳이 없는 곳이다.
            if (x + 1 == n || triangle[y][x + 1] != 0) break;

            x += 1;

            // 오른쪽으로 이동
            while (true) {
                triangle[y][x] = v++;
                if (x + 1 == n || triangle[y][x + 1] != 0) break;
                x += 1;
            }


            // 왼쪽 위 방향이 0이 아니라면 다음으로 갈 곳이 없다.
            if (triangle[y - 1][x - 1] != 0) break;

            x -= 1;
            y -= 1;

            // 왼쪽 위로 이동
            while (true) {
                triangle[y][x] = v++;
                if (triangle[y - 1][x - 1] != 0) break;
                x -= 1;
                y -= 1;
            }

            if (y + 1 == n || triangle[y + 1][x] != 0) break;
            y += 1;
        }

        int[] result = new int[v - 1];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                result[index++] = triangle[i][j];
            }
        }


        return result;
    }
}
