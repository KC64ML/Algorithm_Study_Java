package programmers.LV2.삼각_달팽이;

public class Solution3 {

    private final int[] dx = {0, 1, -1};
    private final int[] dy = {1, 0, -1};

    private int x, y;

    public int[] solution(int n) {
        int[][] arr = new int[n][n];
        int idx = 0;
        int count = 2;
        arr[0][0] = 1;
        while(true){
            int nx = x + dx[idx % 3];
            int ny = y + dy[idx % 3];

            if(nx >= n || ny >= n || nx < 0 || ny < 0 || arr[ny][nx] != 0){
                idx += 1;
                nx = x + dx[idx % 3];
                ny = y + dy[idx % 3];


                if(nx >= n || ny >= n || nx < 0 || ny < 0 || arr[ny][nx] != 0){
                    break;
                }
            }

            arr[ny][nx] = count;
            x = nx;
            y = ny;
            count++;
        }

        int[] answer = new int[count - 1];
        int resIdx = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= i; j++){
                answer[resIdx++] = arr[i][j];
            }
        }

        return answer;
    }
}
