package 메이즈_러너;

import java.util.*;
import java.io.*;

public class Solution {

    private static class Participate{
        public final int x;
        public final int y;
        public final int streetCnt;

        public Participate(int x, int y, int streetCnt){
            this.x = x;
            this.y = y;
            this.streetCnt = streetCnt;
        }
    }

    private static int N, M, K;
    private static int[][] arr;
    private static int exitX, exitY;
    private static int answer;
    private static int peopleCount;

    private static int[] dx = {0, 0, -1 ,1};
    private static int[] dy = {-1, 1, 0, 0};

    private static boolean isWithInRange(int x, int y){
        if(0 <= x && 0 <= y && x < N && y < N) return true;
        else return false;
    }

    private static int getCalculateStreet(int x, int y){
        return Math.abs(x - exitX) + Math.abs(y - exitY);
    }

    // 사람들 위치 이동
    private static void movePeopleBfs(){
        Queue<Participate> queue = new LinkedList<>();
        queue.add(new Participate(exitX, exitY, 0));
        boolean[][] visited = new boolean[N][N];
        visited[exitY][exitX] = true;

        while(queue.size() > 0){
            Participate part = queue.poll();
            int curX = part.x;
            int curY = part.y;

            for(int i = 0; i < 4; i++){
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if(isWithInRange(nx, ny)){
                    if(visited[ny][nx]) continue;
                    visited[ny][nx] = true;

                    // 벽이 있는 위치라면 pass
                    if(1 <= arr[ny][nx] && arr[ny][nx] < 10) continue;

                    // 사람이 있는 위치라면 확인한다.
                    if(arr[ny][nx] == 100){
                        // 사람 위치 방문, 최단 거리라면, 위치 이동
                        System.out.println("ny : " + ny + " nx : " + nx + " exit " + exitY + " " + exitX);
                        System.out.println(getCalculateStreet(nx, ny) + " " + part.streetCnt);
                        if(getCalculateStreet(nx, ny) == part.streetCnt + 1){
                            answer += 1;
                            System.out.println("answer 추가");
                            // EXIT 위치가 아니라면 사람의 위치 업데이트
                            if(curY == exitY && curX == exitX) peopleCount--;
                            else arr[curY][curX] = 100;
                            arr[ny][nx] = 0;

                            for(int k = 0 ; k < arr.length; k++){
                                System.out.println(Arrays.toString(arr[k]));
                            }
                        }
                    }else{
                        queue.add(new Participate(nx, ny, part.streetCnt + 1));
                    }


                }
            }
        }
    }

    private static int[] getfindSquareStartEndXYToBFS(){
        // bfs로 현재 가장가까운 사람 위치를 찾는다.
        Queue<Participate> queue = new LinkedList<>();
        queue.add(new Participate(exitX, exitY, 0));
        boolean[][] visited = new boolean[N][N];
        visited[exitY][exitX] = true;
        int firstX = exitX;
        int firstY = exitY;
        int firstStreet = Integer.MAX_VALUE;

        while(queue.size() > 0){
            Participate part = queue.poll();
            int curX = part.x;
            int curY = part.y;

            if(firstStreet < part.streetCnt) continue;

            for(int i = 0; i < 4; i++){
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if(isWithInRange(nx, ny)){
                    if(visited[ny][nx]) continue;
                    visited[ny][nx] = true;

                    // 사람이 있는 위치라면 확인한다.
                    if(arr[ny][nx] == 100){

                        int curStreet = getCalculateStreet(nx, ny);
                        System.out.println("거리 : " + curStreet);
//                        System.out.println("nx, ny : " + nx + " " + ny + " curX, curY : " + curX + " " + curY);
//                        System.out.println("firstStree : " + firstStreet + " " + curStreet);
                        if(firstStreet > curStreet){
                            firstStreet = curStreet;
                            firstX = nx;
                            firstY = ny;
                            break;
                        }
                        else if(firstStreet == curStreet){
                            // 최단 거리가 같다면 y축 위, x 축 왼쪽
                            if(firstY > ny || (firstY == ny && firstX > nx)){
                                firstX = nx;
                                firstY = ny;
                                break;
                            }
                        }

                    }else {
                        // 사람이 있는 위치가 아니면 queue에 삽입한다.
                        queue.add(new Participate(nx, ny, part.streetCnt + 1));
                    }


                }
            }
        }

        // x, y중 큰 값
        int squareLen = Math.max(Math.abs(firstX - exitX), Math.abs(firstY - exitY)) + 1;
        System.out.println("firstX, firstY : " + firstX + " " + firstY + " squareLen : " + squareLen);
        int startX = Math.max(firstX, exitX) - (squareLen - 1);
        int startY = Math.max(firstY, exitY) - (squareLen - 1);
        if(startX < 0) startX = 0;
        if(startY < 0) startY = 0;

        return new int[] {startX, startY, startX + squareLen, startY + squareLen};
    }

    private static int[][] deepCopy(int[][] copyArr){
        int[][] testCase = new int[copyArr.length][copyArr[0].length];

        for(int i = 0; i < copyArr.length; i++){
            testCase[i] = copyArr[i].clone();
        }

        return testCase;
    }

    private static void rightRotate90(){
        int[] square = getfindSquareStartEndXYToBFS();
        int squareLen = square[2] - square[0];
        int startX = square[0];
        int startY = square[1];
        int[][] testCase = new int[squareLen][squareLen];

        for(int i = startY; i < startY + squareLen; i++){
            for(int j = startX; j < startX + squareLen; j++){
                testCase[i - startY][j - startX] = arr[i][j];
            }
        }

        int[][] testCase2 = deepCopy(testCase);
        for(int i = 0; i < squareLen; i++){
            for(int j = 0; j < squareLen; j++){
                testCase[i][j] = testCase2[squareLen - j - 1][i];
            }
        }

        for(int i = startY; i < startY + squareLen; i++){
            for(int j = startX; j < startX + squareLen; j++){
                arr[i][j] = testCase[i - startY][j - startX];
                if(1 <= arr[i][j] && arr[i][j] <= 9) arr[i][j] -= 1;
                else if(arr[i][j] == -100){
                    exitX = j;
                    exitY = i;
                }
            }
        }

    }

    private static void printXY(){
        for(int i = 0; i < N; i++){
            System.out.println(Arrays.toString(arr[i]));
        }

        System.out.println();
    }
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());
        K = Integer.parseInt(tokenizer.nextToken());

        arr = new int[N][N];

        for(int i = 0; i < N; i++){
            tokenizer = new StringTokenizer(reader.readLine());
            for(int j = 0; j < N; j++){
                arr[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        // 100 : 사람 위치
        for(int i = 0; i < M; i++){
            tokenizer = new StringTokenizer(reader.readLine());
            int row = Integer.parseInt(tokenizer.nextToken()) - 1;
            int col = Integer.parseInt(tokenizer.nextToken()) - 1;

            arr[row][col] = 100;
        }

        peopleCount = M;

        tokenizer = new StringTokenizer(reader.readLine());


        int row = Integer.parseInt(tokenizer.nextToken()) - 1;
        int col = Integer.parseInt(tokenizer.nextToken()) - 1;

         arr[row][col] = -100;
        exitX = col;
        exitY = row;

        // M개수가 0개 일 때까지 반복
        for(int i = 1; i <= K; i++){
            // 1. 참가자 조회
            movePeopleBfs();
            if(peopleCount == 0) break;

            // 2. 회전
            rightRotate90();
            System.out.println(i + " 번 결과");
            System.out.println(exitY + " " + exitX);
            printXY();
        }

        System.out.println(answer);

        reader.close();
    }
}