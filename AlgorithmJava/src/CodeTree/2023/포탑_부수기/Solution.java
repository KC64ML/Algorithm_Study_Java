package 포탑_부수기;

import java.io.*;
import java.util.*;

public class Solution {
    public static class Turrent implements Comparable<Turrent> {
        int x, y, time, attack;

        public Turrent(int x, int y, int time, int attack) {
            this.x = x;
            this.y = y;
            this.time = time;
            this.attack = attack;
        }

        public int compareTo(Turrent turrent){
            // 1인 경우 this 객체가 해당객체보다 뒤에 위치한다.
            // -1인 경우 this 객체가 해당 객체보다 앞에 위치한다.
            if(this.attack != turrent.attack) return this.attack - turrent.attack;
            if(this.time != turrent.time) return turrent.time - this.time;
            if(this.x + this.y != turrent.x + turrent.y) return (turrent.x + turrent.y) - (this.x + this.y);
            else return turrent.x - this.x;
        }
    };

    private static int N, M, K;
    private static int[][] attackArr;
    private static int[][] timeArr;
    private static int gameTime;
//    private static int countAttacker;
    private static ArrayList<Turrent> liveTurret;

    // 우 하 좌 상
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static int[][] dxy = {{-1, -1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}, {0, 1}, {-1, 1}, {-1, 0}};
    private static boolean[][] visitedAttack;

    private static boolean laserAttack(){
        Queue<Integer> queue = new LinkedList<>();
//        System.out.println(liveTurret.get(0).x + " " + liveTurret.get(0).y);
//        System.out.println(liveTurret.get(liveTurret.size() - 1).x + " " + liveTurret.get(liveTurret.size() - 1).y);
        // 1, 2, 3, 4
        int[][] direction = new int[N][M];
        queue.add(liveTurret.get(0).x);
        queue.add(liveTurret.get(0).y);


        while(queue.size() > 0){
            int curX = queue.poll();
            int curY = queue.poll();

            if(curX == liveTurret.get(liveTurret.size() - 1).x && curY == liveTurret.get(liveTurret.size() - 1).y){
//                System.out.println("실행");
                // 도착했을 때
                // 역방향 저장 (방향 1, 2, 3, 4 저장되어 있다.)
                int d = direction[curY][curX] - 1;
                visitedAttack[curY][curX] = true;
                // timeArr[curY][curX] = time;

                ArrayList<Integer> result = new ArrayList<>();
                result.add(curX);
                result.add(curY);
                int nextX = curX;
                int nextY = curY;

                while(!(nextX == liveTurret.get(0).x && nextY == liveTurret.get(0).y)){
                    nextX = (nextX + dx[d]) % M;
                    nextY = (nextY + dy[d]) % N;

                    if(nextX < 0) nextX = M - 1;
                    if(nextY < 0) nextY = N - 1;
                    // timeArr[nextY][nextX] = time;
                    visitedAttack[nextY][nextX] = true;
                    result.add(nextX);
                    result.add(nextY);

                    d = direction[nextY][nextX] - 1;
                }
                Collections.reverse(result);
                // 모든 방향을 찾았다면
                for(int i = 2; i < result.size() - 2; i += 2){
                    int ny = result.get(i);
                    int nx = result.get(i + 1);

                    attackArr[ny][nx] -= attackArr[liveTurret.get(0).y][liveTurret.get(0).x] / 2;
                    if(attackArr[ny][nx] <= 0){
                        attackArr[ny][nx] = 0;
//                        countAttacker -= 1;
                    }
                }
                int findY = result.get(result.size() - 2);
                int findX = result.get(result.size() - 1);
                attackArr[findY][findX] -= attackArr[liveTurret.get(0).y][liveTurret.get(0).x];
                if(attackArr[findY][findX] <= 0) {
                    attackArr[findY][findX] = 0;
//                    countAttacker -= 1;
                }

                for(int i = 0; i < liveTurret.size(); i++){
                    Turrent t = liveTurret.get(i);
//                    System.out.println(t.y + " " + t.x + "  " + attackArr[t.y][t.x]);

                    if(attackArr[t.y][t.x] == 0){
                        liveTurret.remove(i);
                        i -= 1;
                    }

                }
//                System.out.println("검사");
//                for(Turrent t : liveTurret){
//                    System.out.println(t.y + " " + t.x + " " + attackArr[t.y][t.x]);
//                }

//                System.out.println("남은 개수 : " + liveTurret.size());


                return true;
            }

            for(int i = 0; i < 4; i++){
                int nx = (curX + dx[i]) % M;
                int ny = (curY + dy[i]) % N;

                if(nx < 0) nx = M - 1;
                if(ny < 0) ny = N - 1;
                if(attackArr[ny][nx] == 0) continue;
                // 0인 경우 아직 방문하지 않은 곳
                if(direction[ny][nx] != 0) continue;
                direction[ny][nx] = (i + 2) % 4 + 1; // 역방향
                queue.add(nx);
                queue.add(ny);
            }
        }


        return false;

    }
    private static void shellAtack(){
//        System.out.println("방문");
//        boolean[][] visited = new boolean[N][M];
        int maxX = liveTurret.get(liveTurret.size() - 1).x;
        int maxY = liveTurret.get(liveTurret.size() - 1).y;

        int minX = liveTurret.get(0).x;
        int minY = liveTurret.get(0).y;

//        System.out.println("공격자 : " + minY + " " + minX + " 방어자 : " + maxY + " " + maxX + " 공격력 : " + attackArr[minY][minX]);
        // printAttack();
        // 8방향 처리
        for(int i = 0; i < 8; i++){
            int nx = (dxy[i][0] + maxX) % M;
            int ny = (dxy[i][1] + maxY) % N;

            if(nx < 0) nx = M - 1;
            if(ny < 0) ny = N - 1;
            if(nx == minX && ny == minY) continue;
            visitedAttack[ny][nx] = true;
            if(attackArr[ny][nx] == 0) continue;

            attackArr[ny][nx] -= attackArr[minY][minX] / 2;
//            System.out.println(ny + " " + nx + " " + attackArr[ny][nx]);


            if(attackArr[ny][nx] < 0) attackArr[ny][nx] = 0;

        }

        // 대상 처리
//        System.out.println(attackArr[maxY][maxX] + " <= " + attackArr[minY][minX]);
        attackArr[maxY][maxX] -= attackArr[minY][minX];
        visitedAttack[maxY][maxX] = true;

        if(attackArr[maxY][maxX] <= 0) attackArr[maxY][maxX] = 0;

        // List에서 감소시켜야하는 상황
        for(int i = 0; i < liveTurret.size(); i++){
            Turrent t = liveTurret.get(i);
            if(!visitedAttack[t.y][t.x]) continue;
            else{
                if(attackArr[t.y][t.x] == 0) {
                    liveTurret.remove(i);
                    i--;
                }else{
                    /*System.out.println("-1 실행");*/
                    t.attack = attackArr[t.y][t.x];
//                    System.out.println("횟수 확인");
//                    System.out.println(t.y + " " + t.x + " " + t.attack);
                    liveTurret.set(i, t);
                }

            }
        }
//        for(int i  =0 ; i < liveTurret.size(); i++){
//            System.out.println(liveTurret.get(i).y + " " + liveTurret.get(i).x + " " + liveTurret.get(i).attack);
//        }


        // 안되면 답지 보기
//        printAttack();

    }
    private static void maintenance(){

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(visitedAttack[i][j]) continue;
                if(attackArr[i][j] == 0) continue;

//                System.out.println("i " + i + " j "  + j);
                // 포탑 정비
                attackArr[i][j] += 1;
            }
        }
    }
    private static void printAttack(){
        for(int i = 0; i < N; i++){
            System.out.println(Arrays.toString(attackArr[i]));
        }

        System.out.println();
    }

    // 가장 약한 공격자 업데이트
    private static void awake(){
        // 정렬해준다.
        Collections.sort(liveTurret);

        // 가장 약한 공격자
        Turrent turrent = liveTurret.get(0);
        int x = turrent.x;
        int y = turrent.y;

        attackArr[y][x] += (N + M); // 공격
        timeArr[y][x] = gameTime; // 현재 시간
        visitedAttack[y][x] = true;

        turrent.attack = attackArr[y][x];
        turrent.time = timeArr[y][x];

        // 0번 update
        liveTurret.set(0, turrent);
    }
    private static void gameStation(){

        for(int i = 0; i < N; i++){
            Arrays.fill(visitedAttack[i], false);
        }

//        printAttack();
        awake();

        // (3) 레이저 공격을 못했을 때는 포탄 공격
        if(!laserAttack()){

            shellAtack();
//             System.out.println("레이저 공격 실패로 포탄 공격");
        }
//        for(int i = 0; i < N; i++){
//            System.out.println(Arrays.toString(visitedAttack[i]));
//        }
        // (4) 포탑 정비
        maintenance();

        // System.out.println("시간 출력");
        // printTime();

//        printAttack();

//        System.out.println("종료");

    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());
        K = Integer.parseInt(tokenizer.nextToken());
        attackArr = new int[N][M];
        timeArr = new int[N][M];
        visitedAttack = new boolean[N][M];

        for(int i = 0; i < N; i++){
            tokenizer = new StringTokenizer(reader.readLine());
            for(int j = 0; j < M; j++){
                attackArr[i][j] = Integer.parseInt(tokenizer.nextToken());
//                if(attackArr[i][j] > 0) countAttacker++;
            }
        }




        for(int tk = 1; tk <= K; tk++){
            liveTurret = new ArrayList<>();
            for(int i = 0; i < N; i++)
                for(int j = 0; j < M; j++)
                    if(attackArr[i][j] > 0) {
                        Turrent newTurret = new Turrent(j, i, timeArr[i][j], attackArr[i][j]);
                        liveTurret.add(newTurret);
                    }
            // 살아있는 포탑이 1개 이하라면 바로 종료합니다.
            if(liveTurret.size() <= 1)
                break;
            gameTime += 1;

            gameStation();

//            printAttack();
        }

        int maxData = 0;
        for(int i = 0 ; i < N; i++){
            for(int j = 0; j < M; j++){
                if(maxData < attackArr[i][j]) maxData = attackArr[i][j];
            }
        }

        System.out.println(maxData);
        reader.close();
    }
}