package 포탑_부수기;

import java.awt.*;
import java.util.*;
import java.io.*;

public class BJ2178 {


    private static int N, M;
    private static int[][] arr;
    private static int[][] directionArr;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, -1, 0, 1};

    private static class Node{
        public final int x;
        public final int y;
        public final int cnt;

        public Node(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    private static boolean isWithInRange(int row, int col){
        if(0 <= row && 0 <= col && row < N && col < M) return true;
        else return false;
    }
    private static ArrayList<Node> bfs(){
        Queue<Node> queue = new LinkedList<>();
        ArrayList<Node> result = new ArrayList<>();
        queue.add(new Node(0, 0, 1));
        boolean[][] visited = new boolean[N][M];
        visited[0][0] = true;

        while(queue.size() > 0){
            Node n = queue.poll();

            // x, y 좌표가 목적지에 도착했을 때
            if(n.y == N - 1 && n.x == M - 1){
                // 역추적하기
                int d = directionArr[n.y][n.x];
                int curX = n.x;
                int curY = n.y;

                // 역추적으로 좌표를 찾는다.
                for(int i = n.cnt - 1; i > 0; i--){
                    curX = dx[d] + curX;
                    curY = dy[d] + curY;

                    // 역추적
                    result.add(new Node(curX, curY, i));
                    d = directionArr[curY][curX];
                }

                // 역추적 기본 정렬 후, 종료
                Collections.reverse(result);
                break;
            }

            // 상하좌우 검토한다.
            for(int i = 0; i < 4; i++){
                int nx = dx[i] + n.x;
                int ny = dy[i] + n.y;

                if(!isWithInRange(ny, nx)) continue;
                if(arr[ny][nx] == 0) continue;
                if(visited[ny][nx]) continue;
                visited[ny][nx] = true;

                // 역추적 방향을 저장한다.
                directionArr[ny][nx] = (i + 2) % 4;

                // 좌표와 현재 방문한 노드개수 저장
                queue.add(new Node(nx, ny, n.cnt + 1));
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());

        arr = new int[N][M];
        directionArr = new int[N][M];

        for(int i = 0; i < N; i++){
            char[] c = reader.readLine().toCharArray();
            for(int j = 0; j < M; j++){
                arr[i][j] = c[j] - '0';
            }
        }


        bfs();


        reader.close();
    }
}
