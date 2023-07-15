package programmers.LV3.게임_맵_최단거리;

import java.util.Queue;
import java.util.LinkedList;

public class Solution2 {

    private boolean[][] visited;

    private static final int[] dx = {-1, 0, 1, 0};
    private static final int[] dy = {0, 1, 0, -1};

    private static class GameDate{
        public final int x;
        public final int y;
        public final int street;

        GameDate(int x, int y, int street){
            this.x = x;
            this.y = y;
            this.street = street;
        }
    }

    private boolean isWithinRange(int x, int y, int[][] maps){
        return 0 <= x && 0 <= y && x < maps[0].length && y < maps.length;
    }

    private boolean isItZeroCheck(int x, int y, int[][] maps){
        return maps[y][x] == 0;
    }

    public int solution(int[][] maps) {
        Queue<GameDate> queue = new LinkedList<>();
        visited = new boolean[maps.length][maps[0].length];
        queue.add(new GameDate(0,0,1));

        while(!queue.isEmpty()){
            GameDate gameDate = queue.poll();

            if(gameDate.y == maps.length - 1 && gameDate.x == maps[0].length - 1) return gameDate.street;

            for(int i = 0; i < 4; i++){
                int nx = dx[i] + gameDate.x;
                int ny = dy[i] + gameDate.y;

                if(!isWithinRange(nx, ny, maps)) continue;
                if(isItZeroCheck(nx, ny, maps) || visited[ny][nx]) continue;

                visited[ny][nx] = true;
                queue.add(new GameDate(nx, ny, gameDate.street + 1));
            }

        }
        return -1;
    }
}
