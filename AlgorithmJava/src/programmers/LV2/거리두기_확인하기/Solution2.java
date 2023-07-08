package programmers.LV2.거리두기_확인하기;

import java.util.*;

class Solution2 {

    private static final int[] dx = {1, 0, -1, 0};
    private static final int[] dy = {0, 1, 0, -1};

    private int rowLength;
    private int colLength;

    private boolean withInRange(int x, int y){
        if(0 <= x && 0 <= y && x < colLength && y < rowLength) return true;
        return false;
    }

    private boolean isPNearby(int x, int y, char[][] c, int beforeIdx){
        for(int i = 0; i < 4; i++){
            if(i == beforeIdx) continue;

            int nx = x + dx[i];
            int ny = y + dy[i];

            if(withInRange(nx, ny)){
                if(c[ny][nx] == 'P') return false;
            }
        }

        return true;
    }

    private boolean distanceCheck(int x, int y, char[][] c){
        for(int i = 0 ; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 범위 안일 때, 아닌 경우이면 false
            if(withInRange(nx, ny)){
                if(c[ny][nx] == 'P') return false;
                if(c[ny][nx] == 'O' && !isPNearby(nx, ny, c, (i + 2) % 4)) return false;
            }

        }

        return true;
    }

    public int[] solution(String[][] places) {

        List<Integer> answer = new ArrayList<>();

        for(String[] place : places){
            char[][] c = new char[place.length][];

            for(int i = 0 ; i < place.length; i++){
                c[i] = place[i].toCharArray();
            }

            rowLength = place.length;
            colLength = place[0].length();

            boolean check = true;

            Loop1:
            for(int y = 0; y < rowLength; y++){
                for(int x = 0; x < colLength; x++){

                    // 만약 P이고, 다음 번째가 거리가 지켜지지 않았다면
                    if(c[y][x] == 'P' && !distanceCheck(x, y, c)){
                        check = false;
                        break Loop1;
                    }
                }
            }
            if(!check) answer.add(0);
            else answer.add(1);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
