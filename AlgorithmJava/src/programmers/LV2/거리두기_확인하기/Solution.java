package programmers.LV2.거리두기_확인하기;

public class Solution {

    private static final int[] dx = {0, -1, 1, 0};
    private static final int[] dy = {-1, 0, 0, 1};

    boolean isNextToVoluteer(char[][] room, int x, int y, int d){
        for(int i = 0; i < 4; i++){
            if(d == i) continue;

            int nx = x + dx[i];
            int ny = y + dy[i];

            if(0 <= nx && 0 <= ny && nx < room.length && ny < room.length){
                if(room[ny][nx] == 'P') return false;
            }
        }

        return true;
    }

    boolean isDistanced(char[][] room, int x, int y){
        // 상하좌우에서 P가 있다면 false
        // O라면 O 상하좌우에 P가 있다면 false

        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(0 <= nx && 0 <= ny && ny < room.length && nx < room[0].length){
                switch(room[ny][nx]){
                    case 'P': return false;
                    case 'O':
                        if(!isNextToVoluteer(room, nx, ny, 3 - i)) return false;
                        break;
                }
            }
        }

        return true;
    }

    boolean isDistanced(char[][] room){
        // (1) P가 있으면, 체크한다.
        // (2) P가 아닌경우네는 pass
        // 어차피 밑에 있는 인덱스는 나중에 체크하기 때문에 0 ~ 현재위치 인덱스만 판단한다.
        for(int y = 0; y < room.length; y++){
            for(int x = 0; x< room[y].length; x++){
                if(room[y][x] != 'P'){
                    continue;
                }if(!isDistanced(room, x, y)){
                    return false;
                }
            }
        }

        return true;
    }

    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for(int i = 0; i < places.length; i++){
            String[] s = places[i];
            char[][] room = new char[s.length][];

            for(int j = 0; j < places.length; j++){
                room[j] = s[j].toCharArray();
            }

            if(isDistanced(room)){
                answer[i] = 1;
            }else {
                answer[i] = 0;
            }
        }

        return answer;
    }
}
