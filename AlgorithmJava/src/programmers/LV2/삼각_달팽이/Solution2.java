package programmers.LV2.삼각_달팽이;

public class Solution2 {
    // 변하지 않는 상수는 private으로 선언하기

    private static final int[] dx = {0, 1, -1};
    private static final int[] dy = {1, 0, -1};

    public int[] solution(int n) {
        int[][] triangle = new int[n][n];
        int v = 1;
        int x = 0;
        int y = 0;
        int d = 0;

        while(true) {
            triangle[y][x] = v++;
            // dx, dy를 사용하여 모든 방향에 동일한 로직을 적용
            int nx = x + dx[d];
            int ny = y + dy[d];

            // 더이상 현재위치에서 다음위치로 갈 수 없을 때
            if (nx == n || ny == n || nx == -1 || ny == -1 || triangle[ny][nx] != 0){
                d = (d + 1) % 3;
                nx = x + dx[d];
                ny = y + dy[d];

                // 다음위치를 확인했는데 똑같이 더이상 갈 곳이 없다면 out
                // 한 곳이상 이동해야하는데 아예 이동하지 못한 경우
                if (nx == n || ny == n || nx == -1 || ny == -1 || triangle[ny][nx] != 0) break;
            }
            x = nx;
            y = ny;
        }

        int[] result = new int[v - 1];
        int index = 0;
        for(int i =0; i < n ; i++){
            for(int j =0; j <= i; j++){
                result[index++] = triangle[i][j];
            }
        }

        return result;
    }
}
