package 싸움땅;

import java.util.*;
import java.io.*;

public class Solution {
    private static class GameUser{
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
    }

    private static class GameGun{
        public final ArrayList<Integer> gunList = new ArrayList<>();

        GameGun(int gunDamage){
            gunList.add(gunDamage);
        }

        public void addGameGunDamage(int damage){
            gunList.add(damage);
            // add한 후 정렬
        }

        public int findMaxGunDamage(){
            return gunList.get(gunList.size() - 1);
        }

        public void removeMaxGunDamage(){
            gunList.remove(gunList.size() - 1);
        }
    }
    private static int n, m, k;
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {-1, 0, 1, 0};


    private static void gameUserMove(){

    }


    private static void gameUserAttack(){

    }

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());
        k = Integer.parseInt(tokenizer.nextToken());


        GameGun[] gameGunList = new GameGun[n * n];

        for(int i = 0; i < n; i++){
            tokenizer = new StringTokenizer(reader.readLine());
            for(int j = 0; j < n; j++){
                int damage = Integer.parseInt(tokenizer.nextToken());
                int index = i * n + j;
                gameGunList[index] = new GameGun(damage);
            }
        }

        GameUser[] gameUserList = new GameUser[m];

        for(int i = 0 ; i < m; i++){
            tokenizer = new StringTokenizer(reader.readLine());
            int row = Integer.parseInt(tokenizer.nextToken());
            int col = Integer.parseInt(tokenizer.nextToken());
            int d = Integer.parseInt(tokenizer.nextToken());
            int s = Integer.parseInt(tokenizer.nextToken());

            gameUserList[i] = new GameUser(col, row, 0, d, s);
        }

        for(int tk = 1; tk <= k; tk++){
            gameUserMove();

            gameUserAttack();
        }


        reader.close();
    }
}
