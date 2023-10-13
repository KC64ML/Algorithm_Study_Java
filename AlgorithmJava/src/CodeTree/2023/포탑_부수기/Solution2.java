package 포탑_부수기;

import java.io.*;
import java.util.*;

public class Solution2 {

    private static int N, M, K;
    private static int[][] attackArr;
    private static int[][] timeArr;
    private static int countAttacker;

    // 우 하 좌 상
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static int[][] dxy = {{-1, -1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}, {0, 1}, {-1, 1}, {-1, 0}};
    private static boolean[][] visitedAttack;

    private static int[] findMinXY(){
        int number = Integer.MAX_VALUE;
        int minI = 0;
        int minJ = 0;
        for(int i = 0 ; i < N; i++){
            for(int j = 0; j < M; j++){
                if(attackArr[i][j] == 0) continue;
                if(attackArr[i][j] < number){
                    minI = i;
                    minJ = j;
                    number = attackArr[i][j];
                }
            }
        }
        return new int[]{minI, minJ};
    }

    private static int[] findMaxXY(){
        int number = 0;
        int maxI = 0;
        int maxJ = 0;
        for(int i = 0 ; i < N; i++){
            for(int j = 0; j < M; j++){
                if(attackArr[i][j] > number){
                    maxI = i;
                    maxJ = j;
                    number = attackArr[i][j];
                }
            }
        }
        return new int[]{maxI, maxJ};
    }
    private static int[] selectionAttack(){
        int[] findXY = findMinXY();
        int minAttackX = findXY[1];
        int minAttackY = findXY[0];
        // printTime();
        // System.out.println("가장 작은 인덱스 : " + minAttackY + " " + minAttackX);

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                // 0인 경우 제외
                if(attackArr[i][j] == 0) continue;

                if(attackArr[i][j] < attackArr[minAttackY][minAttackX]){
                    // (1) 1-1
                    minAttackX = j;
                    minAttackY = i;
                }else if(attackArr[i][j] == attackArr[minAttackY][minAttackX]
                        && timeArr[i][j] > timeArr[minAttackY][minAttackX]){
                    // (2) 1-2
                    minAttackX = j;
                    minAttackY = i;
                }else if(attackArr[i][j] == attackArr[minAttackY][minAttackX]
                        && timeArr[i][j] == timeArr[minAttackY][minAttackX]
                        && (i + j) > (minAttackY + minAttackX)){
                    // (3) 1-3
                    minAttackX = j;
                    minAttackY = i;
                }else if(attackArr[i][j] == attackArr[minAttackY][minAttackX]
                        && timeArr[i][j] == timeArr[minAttackY][minAttackX]
                        && (i + j) == (minAttackY + minAttackX)
                        && j > minAttackX){
                    // (4) 1-4
                    minAttackX = j;
                    minAttackY = i;
                }
            }
        }

        // System.out.println("공격자 포탑 : " + minAttackY + " " + minAttackX);
        return new int[]{minAttackX, minAttackY};
    }
    private static int[] findToTarget(){
        int[] findXY = findMaxXY();
        int maxAttackX = findXY[1];
        int maxAttackY = findXY[0];
        // System.out.println("시작값 : " +  maxAttackY + " " + maxAttackX);

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                // 0인 경우 제외
                if(attackArr[i][j] == 0) continue;

                if(attackArr[i][j] > attackArr[maxAttackY][maxAttackX]){
                    // (1) 2-1
                    maxAttackY = j;
                    maxAttackY = i;
                }else if(attackArr[i][j] == attackArr[maxAttackY][maxAttackX]
                        && timeArr[i][j] < timeArr[maxAttackY][maxAttackX]){
                    // (2) 1-2
                    maxAttackX = j;
                    maxAttackY = i;
                }else if(attackArr[i][j] == attackArr[maxAttackY][maxAttackX]
                        && timeArr[i][j] == timeArr[maxAttackY][maxAttackX]
                        && (i + j) < (maxAttackY + maxAttackX)){
                    // (3) 1-3
                    maxAttackX = j;
                    maxAttackY = i;
                }else if(attackArr[i][j] == attackArr[maxAttackY][maxAttackX]
                        && timeArr[i][j] == timeArr[maxAttackY][maxAttackX]
                        && (i + j) == (maxAttackY + maxAttackX)
                        && j < maxAttackX){
                    // (4) 1-4
                    maxAttackX = j;
                    maxAttackY = i;
                }
            }
        }

        // System.out.println("공격자 대상 포탑 : " + maxAttackY + " " + maxAttackX);
        return new int[]{maxAttackX, maxAttackY};
    }
    private static boolean laserAttack(int[] minAttackArr, int[] maxAttackArr, int time){
        Queue<Integer> queue = new LinkedList<>();
        // 1, 2, 3, 4
        int[][] direction = new int[N][M];
        queue.add(minAttackArr[0]);
        queue.add(minAttackArr[1]);


        while(queue.size() > 0){
            int curX = queue.poll();
            int curY = queue.poll();

            if(curX == maxAttackArr[0] && curY == maxAttackArr[1]){
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

                while(!(nextX == minAttackArr[0] && nextY == minAttackArr[1])){
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

                    attackArr[ny][nx] -= attackArr[minAttackArr[1]][minAttackArr[0]] / 2;
                    if(attackArr[ny][nx] <= 0){
                        attackArr[ny][nx] = 0;
                        countAttacker -= 1;
                    }
                }
                int findY = result.get(result.size() - 2);
                int findX = result.get(result.size() - 1);
                attackArr[findY][findX] -= attackArr[minAttackArr[1]][minAttackArr[0]];
                if(attackArr[findY][findX] <= 0) {
                    attackArr[findY][findX] = 0;
                    countAttacker -= 1;
                }


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
    private static void shellAtack(int[] minAttackArr, int[] maxAttackArr){
        // printAttack();
        // 8방향 처리
        for(int i = 0; i < 8; i++){
            int nx = (dxy[i][0] + maxAttackArr[0]) % M;
            int ny = (dxy[i][1] + maxAttackArr[1]) % N;

            if(nx < 0) nx = M - 1;
            if(ny < 0) ny = N - 1;

            if(nx == minAttackArr[0] && ny == minAttackArr[1]) continue;
            visitedAttack[ny][nx] = true;
            if(attackArr[ny][nx] == 0) continue;
            attackArr[ny][nx] -= attackArr[minAttackArr[1]][minAttackArr[0]] / 2;

            if(attackArr[ny][nx] <= 0) {
                attackArr[ny][nx] = 0;
                countAttacker -= 1;
            }
        }

        // 대상 처리
        attackArr[maxAttackArr[1]][maxAttackArr[0]] -= attackArr[minAttackArr[1]][minAttackArr[0]];
        if(attackArr[maxAttackArr[1]][maxAttackArr[0]] <= 0){
            attackArr[maxAttackArr[1]][maxAttackArr[0]] = 0;
            countAttacker -= 1;
        }

    }
    private static void maintenance(){

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(visitedAttack[i][j]) continue;
                if(attackArr[i][j] == 0) continue;

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

    private static void printTime(){
        for(int i = 0; i < N; i++){
            System.out.println(Arrays.toString(timeArr[i]));
        }

        System.out.println();
    }
    private static void gameStation(int time){

        for(int i = 0; i < N; i++){
            Arrays.fill(visitedAttack[i], false);
        }

        // (1)
        int[] minAttackArr = selectionAttack();
        // (2)
        int[] maxAttackArr = findToTarget();
        timeArr[minAttackArr[1]][minAttackArr[0]] = time;
        // 방문처리
        visitedAttack[maxAttackArr[1]][maxAttackArr[0]] = true;
        visitedAttack[minAttackArr[1]][minAttackArr[0]] = true;

        // 공격력 증가
        attackArr[minAttackArr[1]][minAttackArr[0]] += (N + M);


        // (3) 레이저 공격을 못했을 때는 포탄 공격
        if(!laserAttack(minAttackArr, maxAttackArr, time)){
            shellAtack(minAttackArr, maxAttackArr);
            // System.out.println("레이저 공격 실패로 포탄 공격");
        }

        // (4) 포탑 정비
        maintenance();

        // System.out.println("시간 출력");
        // printTime();

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
                if(attackArr[i][j] > 0) countAttacker++;
            }
        }

        for(int tk = 1; tk <= K; tk++){
            gameStation(tk);
//            printAttack();
            if(countAttacker == 1) break;

        }

        int[] findXY = findMaxXY();
        System.out.println(attackArr[findXY[0]][findXY[1]]);
        reader.close();
    }
}