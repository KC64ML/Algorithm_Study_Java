package 싸움땅;

import java.util.*;
import java.io.*;

public class Solution {
    private static class GameUser implements Comparable<GameUser>{
        public final int x;
        public final int y;
        public final int attack;
        public final int gameGun;
        public final int direction;

        GameUser(int x, int y, int attack, int gameGun, int direction){
            this.x = x;
            this.y = y;
            this.attack = attack;
            this.gameGun = gameGun;
            this.direction = direction;
        }

//        public GameUser updateGameUserData(int x, int y, int attack, int gameGun, int direction){
//            return new GameUser(x, y, attack, gameGun, direction);
//        }

        public int compareTo(GameUser user){
            return (this.attack + this.gameGun) - (user.attack + this.gameGun);
        }
    }

    private static class GameGun{
        public final ArrayList<Integer> gunList = new ArrayList<>();

        GameGun(int gunDamage){
            gunList.add(gunDamage);
        }

        public void addGameGunDamage(int damage){
            gunList.add(damage);
            // add한 후 정렬
            Collections.sort(gunList);
        }

        public int gameGunSize(){
            return gunList.size();
        }
        public int findMaxGunDamage(){
            return gunList.get(gunList.size() - 1);
        }
        public int removeMaxGunDamage(){
            int maxDamage = gunList.get(gunList.size() - 1);
            gunList.remove(gunList.size() - 1);
            return maxDamage;
        }
    }

    private static int n, m, k;
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {-1, 0, 1, 0};
    private static ArrayList<GameUser> gameUserList;
    private static ArrayList<GameGun> gameGunList;

    private static boolean isWithInRange(int row, int col){
        if(0 <= row && 0 <= col && row < n && col < n) return true;
        else return false;
    }

    // 사용자들 이동
    private static void gameUserMove(){
        // gameUserList
        for(int i = 0; i < gameUserList.size(); i++){
            int direction = gameUserList.get(i).direction;
            int nx = gameUserList.get(i).x + dx[direction];
            int ny = gameUserList.get(i).y + dy[direction];
            int gameGun = gameUserList.get(i).gameGun;

            // 범위를 벗어난 경우 반대방향
            if(!isWithInRange(ny, nx)){
                nx = gameUserList.get(i).x + dx[(direction + 2) % 4];
                ny = gameUserList.get(i).y + dy[(direction + 2) % 4];
                direction = (direction + 2) % 4;
            }

//            System.out.println(gameUserList.get(i).y + " " + gameUserList.get(i).x + " 는 =>" + ny + " " + nx + " direction : " + direction);
            // 좌표 업데이트 후 총 줍기
            // 배열인덱스 % 열 + 배열인덱스 / 행 : 좌표
            // ny * n + nx : 일차원방면 좌표
            int curIndex = ny * n + nx;
            // gameGunList[i].gunList.get(curIndex);

            // 해당 위치에 총이 있다면
            if(gameGunList.get(curIndex).gameGunSize() > 0){
                int maxGameGunDamage = gameGunList.get(curIndex).findMaxGunDamage();
                // 현재 소재하고 있는 총의 힘보다 쌘 총이 있다면 변경
                if(maxGameGunDamage > gameGun){
                    // 사용자가 소유한 총의 힘 초기값 0
                    if(gameGun > 0) gameGunList.get(curIndex).addGameGunDamage(gameGun);
                    gameGun = gameGunList.get(curIndex).removeMaxGunDamage();
                }
            }

            gameUserList.set(i, new GameUser(nx, ny, gameUserList.get(i).attack, gameGun, direction));
        }
    }

    // 동일한 위치에 사용자들이 있을 때
    private static void gameUserAttack(){
        boolean[] visited = new boolean[gameUserList.size()];
        for(int i = 0; i < gameUserList.size(); i++){
            int curX = gameUserList.get(i).x;
            int curY = gameUserList.get(i).y;
            int curDamage = gameUserList.get(i).attack + gameUserList.get(i).gameGun;
            int curDirection = gameUserList.get(i).direction;

            for(int j = 0; j < gameUserList.size(); j++){
                if(i == j) continue;
                if(visited[i] || visited[j]) continue;

                int nextX = gameUserList.get(j).x;
                int nextY = gameUserList.get(j).y;
                int nextDamage = gameUserList.get(j).attack + gameUserList.get(j).gameGun;
                int nextDirection = gameUserList.get(j).direction;

            }
        }
    }

    private static void printGameUser(){
        for(int i = 0; i < gameUserList.size(); i++){
            System.out.println(gameUserList.get(i).y + " " + gameUserList.get(i).x + " " +
                    gameUserList.get(i).attack + " " + gameUserList.get(i).gameGun + " " + gameUserList.get(i).direction);
        }
    }
    private static void gameStation(){
        gameUserMove();
        printGameUser();
        gameUserAttack();
    }

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());
        k = Integer.parseInt(tokenizer.nextToken());


        gameGunList = new ArrayList<>();

        for(int i = 0; i < n; i++){
            tokenizer = new StringTokenizer(reader.readLine());
            for(int j = 0; j < n; j++){
                int damage = Integer.parseInt(tokenizer.nextToken());
//                int index = i * n + j;
                gameGunList.add(new GameGun(damage));
            }
        }

        gameUserList = new ArrayList<>();

        for(int i = 0 ; i < m; i++){
            tokenizer = new StringTokenizer(reader.readLine());
            int row = Integer.parseInt(tokenizer.nextToken()) - 1;
            int col = Integer.parseInt(tokenizer.nextToken()) - 1;
            int d = Integer.parseInt(tokenizer.nextToken());
            int s = Integer.parseInt(tokenizer.nextToken());

            gameUserList.add(new GameUser(col, row, s, 0, d));
        }

        for(int tk = 1; tk <= k; tk++){

            gameStation();

        }


        reader.close();
    }
}
