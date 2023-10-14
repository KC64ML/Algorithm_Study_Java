package 싸움땅;

import java.util.*;
import java.io.*;

public class Solution2 {
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
    private static int[][] maxUserStore;
    private static ArrayList<GameUser> gameUserList;
    private static ArrayList<GameGun> gameGunList;
    private static int[] result;

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
            int attack = gameUserList.get(i).attack;

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
            int curGunIndex = ny * n + nx;
            // gameGunList[i].gunList.get(curIndex);

            // 사용자가 없고 해당 위치에 총이 있다면
            if(maxUserStore[ny][nx] == 0 && gameGunList.get(curGunIndex).gameGunSize() > 0){
                // 이전은 0, 새로운 곳은 i + 1 사용자 번호
                maxUserStore[gameUserList.get(i).y][gameUserList.get(i).x] = 0;
                maxUserStore[ny][nx] = i + 1;
                int maxGameGunDamage = gameGunList.get(curGunIndex).findMaxGunDamage();
                // 현재 소재하고 있는 총의 힘보다 쌘 총이 있다면 변경
                if(maxGameGunDamage > gameGun){
                    // 사용자가 소유한 총의 힘 초기값 0
                    if(gameGun > 0) gameGunList.get(curGunIndex).addGameGunDamage(gameGun);
                    gameGun = gameGunList.get(curGunIndex).removeMaxGunDamage();
                }

                gameUserList.set(i, new GameUser(nx, ny, gameUserList.get(i).attack, gameGun, direction));
            }else if(maxUserStore[ny][nx] > 0) {
                // 사용자가 있다면
                int maxUserIndex = maxUserStore[ny][nx] - 1;
                maxUserStore[gameUserList.get(i).y][gameUserList.get(i).x] = 0;
                // 현재 저장되어 있는 사용자 공격력과 새로 들어온 공격자의 공격력 비교
                int curStoreUserAttack = gameUserList.get(maxUserIndex).gameGun + gameUserList.get(maxUserIndex).attack;
                int newUserAttack = gameGun + attack;

                // 기존 소유자 공격력이 작은 경우, 총을 버리고 90도 회전 or 전진
                if (curStoreUserAttack < newUserAttack) {
                    GameUser updateUser = gameUserList.get(maxUserIndex);
                    gunRelatedUpdate(i, curGunIndex, updateUser, ny, nx);
//                    // 현재 총을 위치에 버린다.
//                    gameGunList.get(curGunIndex).addGameGunDamage(updateUser.gameGun);
//
//                    // 현재 사용자 총과 비교해서 사용자 총 변경
//                    if(gameUserList.get(i).gameGun < gameGunList.get(curGunIndex).findMaxGunDamage()){
//                        gameGunList.get(curGunIndex).addGameGunDamage(gameUserList.get(i).gameGun);
//                        int changeGunDamage = gameGunList.get(curGunIndex).removeMaxGunDamage();
//                        gameUserList.set(i, new GameUser(nx, ny, gameUserList.get(i).attack, changeGunDamage, gameUserList.get(i).direction));
//                    }
                    // 현재 위치에서 가장 강한 사용자의 인덱스를 저장한다.
                    maxUserStore[ny][nx] = i + 1;

                    moveCoordinate(maxUserIndex, ny, nx);
                    // 좌표 이동
//                    int nextY = ny + dy[updateUser.direction];
//                    int nextX = nx + dx[updateUser.direction];
//
//                    if (!isWithInRange(nextY, nextX) || maxUserStore[nextY][nextX] > 0) {
//                        // 90도 회전해야하는 상황 - 다음 위치가 범위 밖이거나, 다른 사용자가 있을 경우
//                        gameUserList.set(maxUserIndex, new GameUser(nx, ny, updateUser.attack, 0, (updateUser.direction + 1) % 4));
//                    } else if (isWithInRange(nextY, nextX) && maxUserStore[nextY][nextX] == 0) {
//                        // 범위 안이고 다른 사용자가 없을 경우
//                        int nextGunIndex = nextY * n + nextX;
//                        int gunPower = 0;
//                        // 새로운 위치에 총이 있다면
//                        if (gameGunList.get(nextGunIndex).gameGunSize() > 0) {
//                            gunPower = gameGunList.get(nextGunIndex).removeMaxGunDamage();
//                        }
//                        maxUserStore[nextY][nextX] = (maxUserIndex + 1);
//                        gameUserList.set(maxUserIndex, new GameUser(nextX, nextY, updateUser.attack, gunPower, updateUser.direction));
//                    }
                } else if (curStoreUserAttack > newUserAttack) {
                    // 새로운 사용자의 공격력이 더 낮다면
                    // - 총을 꺼내고, gameGun.add
                    // - 좌표 이동

                    // 현재 값보다 i가 작은 경우
                    GameUser updateUser = gameUserList.get(i);
                    gunRelatedUpdate(maxUserIndex, curGunIndex, updateUser, ny, nx);
//                    // 현재 총을 위치에 버린다.
//                    gameGunList.get(curGunIndex).addGameGunDamage(updateUser.gameGun);
//
//                    // 현재 사용자 총과 비교해서 사용자 총 변경
//                    if(gameUserList.get(maxUserIndex).gameGun < gameGunList.get(curGunIndex).findMaxGunDamage()){
//                        gameGunList.get(curGunIndex).addGameGunDamage(gameUserList.get(maxUserIndex).gameGun);
//                        int changeGunDamage = gameGunList.get(curGunIndex).removeMaxGunDamage();
//                        gameUserList.set(maxUserIndex, new GameUser(nx, ny, gameUserList.get(maxUserIndex).attack, changeGunDamage, gameUserList.get(maxUserIndex).direction));
//                    }

                    moveCoordinate(i, ny, nx);
                    // 좌표 이동
//                    int nextY = ny + dy[updateUser.direction];
//                    int nextX = nx + dx[updateUser.direction];
//
//                    if (!isWithInRange(nextY, nextX) || maxUserStore[nextY][nextX] > 0) {
//                        // 90도 회전해야하는 상황 - 다음 위치가 범위 밖이거나, 다른 사용자가 있을 경우
//                        gameUserList.set(i, new GameUser(nx, ny, updateUser.attack, 0, (updateUser.direction + 1) % 4));
//                    } else if (isWithInRange(nextY, nextX) && maxUserStore[nextY][nextX] == 0) {
//                        // 범위 안이고 다른 사용자가 없을 경우
//                        int nextGunIndex = nextY * n + nextX;
//                        int gunPower = 0;
//                        // 새로운 위치에 총이 있다면
//                        if (gameGunList.get(nextGunIndex).gameGunSize() > 0) {
//                            gunPower = gameGunList.get(nextGunIndex).removeMaxGunDamage();
//                        }
//                        maxUserStore[nextY][nextX] = (maxUserIndex + 1);
//                        gameUserList.set(i, new GameUser(nextX, nextY, updateUser.attack, gunPower, updateUser.direction));
//                    }
                }else {
                    // 초기 능력치 + 공격력이 같은 경우
                    // 초기 능력치로 비교한다.
                    // gameUserList에서 maxUserIndex의 attack 과 gameUserList에서 i의 attack을 비교해서 더 작은 거를 이동
                    if(gameUserList.get(maxUserIndex).attack > attack){
                        GameUser updateUser = gameUserList.get(i);
                        gunRelatedUpdate(maxUserIndex, curGunIndex, updateUser, ny, nx);
                        moveCoordinate(i, ny, nx);
                    }else if(gameUserList.get(maxUserIndex).attack < attack){

                        GameUser updateUser = gameUserList.get(maxUserIndex);
                        gunRelatedUpdate(i, curGunIndex, updateUser, ny, nx);
                        // 현재 위치에서 가장 강한 사용자의 인덱스를 저장한다.
                        maxUserStore[ny][nx] = i + 1;
                        moveCoordinate(maxUserIndex, ny, nx);
                    }

                }
            }
        }
    }

    private static void gunRelatedUpdate(int index, int curGunIndex, GameUser updateUser, int ny, int nx){
        // 현재 총을 위치에 버린다.
        gameGunList.get(curGunIndex).addGameGunDamage(updateUser.gameGun);

        // 현재 사용자 총과 비교해서 사용자 총 변경
        if(gameUserList.get(index).gameGun < gameGunList.get(curGunIndex).findMaxGunDamage()){
            gameGunList.get(curGunIndex).addGameGunDamage(gameUserList.get(index).gameGun);
            int changeGunDamage = gameGunList.get(curGunIndex).removeMaxGunDamage();
            gameUserList.set(index, new GameUser(nx, ny, gameUserList.get(index).attack, changeGunDamage, gameUserList.get(index).direction));
        }

    }

    // maxUserIndex, i, ny, nx
    private static void moveCoordinate(int index, int ny, int nx){
        GameUser updateUser = gameUserList.get(index);
        // 좌표 이동
        int nextY = ny + dy[updateUser.direction];
        int nextX = nx + dx[updateUser.direction];

        if (!isWithInRange(nextY, nextX) || maxUserStore[nextY][nextX] > 0) {
            // 90도 회전해야하는 상황 - 다음 위치가 범위 밖이거나, 다른 사용자가 있을 경우
            nextY = ny + dy[(updateUser.direction + 1) % 4];
            nextX = nx + dx[(updateUser.direction + 1) % 4];
            System.out.println("확인 : " + nextY + " " + nextX + " " + maxUserStore[nextY][nextX]);



            if(maxUserStore[nextY][nextX] == 0){
                System.out.println("실행");
                maxUserStore[nextY][nextX] = (index + 1);
                gameUserList.set(index, new GameUser(nextX, nextY, updateUser.attack, 0, (updateUser.direction + 1) % 4));
            }
            else gameUserList.set(index, new GameUser(nx, ny, updateUser.attack, 0, (updateUser.direction + 1) % 4));

            printMaxUserStore();
        } else if (isWithInRange(nextY, nextX) && maxUserStore[nextY][nextX] == 0) {
            // 범위 안이고 다른 사용자가 없을 경우
            int nextGunIndex = nextY * n + nextX;
            int gunPower = 0;
            // 새로운 위치에 총이 있다면
            if (gameGunList.get(nextGunIndex).gameGunSize() > 0) {
                gunPower = gameGunList.get(nextGunIndex).removeMaxGunDamage();
            }
            maxUserStore[nextY][nextX] = (index + 1);
            gameUserList.set(index, new GameUser(nextX, nextY, updateUser.attack, gunPower, updateUser.direction));
        }

    }

    private static void printMaxUserStore(){
        for(int i = 0 ; i < n; i++){
            System.out.println(Arrays.toString(maxUserStore[i]));

        }
    }

    private static void printGameUser(){
        for(int i = 0; i < gameUserList.size(); i++){
            System.out.println(gameUserList.get(i).y + " " + gameUserList.get(i).x + " " +
                    gameUserList.get(i).attack + " " + gameUserList.get(i).gameGun + " " + gameUserList.get(i).direction);
        }
        System.out.println();
    }
    private static void gameStation(){
        gameUserMove();
        printGameUser();
//        gameUserAttack();
    }

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());
        k = Integer.parseInt(tokenizer.nextToken());

        gameGunList = new ArrayList<>();
        maxUserStore = new int[n][n];
        result = new int[n];

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
