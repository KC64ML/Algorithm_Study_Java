package 메이즈_러너;

import java.util.*;
import java.io.*;

public class Main2 {

    private static int N, M, K;
    private static int[][] arr;
    private static int exitX, exitY;
    private static int moveStreetSum;

    private static int[] dx = {0, 0, -1 ,1};
    private static int[] dy = {-1, 1, 0, 0};

    private static boolean isWithInRange(int x, int y){
        if(0 <= x && 0 <= y && x < N && y < N) return true;
        else return false;
    }

    private static int getCalculateStreet(int x, int y){
        return Math.abs(x - exitX) + Math.abs(y - exitY);
    }

    private static int[] findExitXY(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(arr[i][j] == -10) return new int[]{i, j};
            }
        }

        return new int[]{0, 0};
    }

    private static int[][] deepCopy(int[][] copytestCase){
        int[][] testCase = new int[copytestCase.length][copytestCase[0].length];

        for(int i = 0; i < copytestCase.length; i++){
            testCase[i] = copytestCase[i].clone();
        }

        return testCase;
    }

    private static void printStreet(){
        for(int i = 0; i < N; i++){
            System.out.println(Arrays.toString(arr[i]));
        }

        System.out.println();
    }
    // 배열이 위치를 이동한다.
    private static void move(){

        // 복사 배열
        int[][] newArr = new int[N][N];
        int[] exitArr = findExitXY();
        exitY = exitArr[0];
        exitX = exitArr[1];

        // System.out.println("exit : " + exitY + " " + exitX);

        // 배열이 돌면서 참가자가 이동할 수 있다면 이동한다.
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                // exit이거나 벽인경우 pass 한다.
                if(-10 <= arr[i][j] && arr[i][j] <= -1){
                    newArr[i][j] = arr[i][j];
                    continue;
                }
                // 빈 공간이거나 출구라면 pass
                if(arr[i][j] == 0) continue;

                // 거리를 구한다.
                int distance = getCalculateStreet(j, i);
                int minDistance = distance;

                int minX = 0, minY = 0;
                // 상하좌우 움직이면서 다음번째가 최단 거리보다 작은 값이라면 update
                for(int d = 0; d < 4; d++){
                    int ny = dy[d] + i;
                    int nx = dx[d] + j;

                    // 범위 밖이거나, 벽이라면 continue
                    if(!isWithInRange(nx, ny)) continue;
                    if(-9 <= arr[ny][nx] && arr[ny][nx] <= -1) continue;

                    int curDistance = getCalculateStreet(nx, ny);
                    // System.out.println(i + " " + j + " " + " ny : " + ny + " nx: " + nx +  " 거리 : " + curDistance);

                    // 최단 거리라면 업데이트
                    if(minDistance > curDistance){
                        minX = nx;
                        minY = ny;
                        minDistance = curDistance;
                        // System.out.println(i + " " + j + " 실행 ");
                        // break;
                    }

                }


                // 다음 방문할 곳이 없으면 새로운 배열에 복사
                if(minDistance == distance){
                    newArr[i][j] += arr[i][j];
                    continue;
                }

                moveStreetSum += arr[i][j];

                // 도착지점이면 continue;
                // 아니면 값 변경
                if(minY == exitY && minX == exitX) continue;
                else newArr[minY][minX] += arr[i][j];

            }

            // for(int k = 0; k < N; k++){
            //     System.out.print(Arrays.toString(arr[k]));
            // }
            // System.out.println();

        }

        for(int i = 0 ; i < N; i++){
            for(int j = 0; j < N; j++){
                arr[i][j] = newArr[i][j];
            }
        }
    }

    // 2. 90도 회전
    private static void rotate90(){

        int distance = Integer.MAX_VALUE;
        int[] exitArr = findExitXY();
        exitY = exitArr[0];
        exitX = exitArr[1];

        // (1) EXIT에서 제일 가까운 사람 위치를 찾는다.
        // (2) 좌상단 r 우선, 이후 c 우선
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(arr[i][j] > 0){
                    int curDistance = getCalculateStreet(j, i);
                     System.out.println(j + " " + i +  " 과 " + exitX + " " + exitY + " 은 " + curDistance);
                    distance = Math.min(distance, curDistance);
                }
            }
        }


        // 시작위치를 찾는다.
        int startRow = -1;
        int startCol = -1;

        Loop1:
        for(int i = 0; i < N - distance; i++){
            for(int j = 0; j < N - distance; j++){
                // 내부에 exit와 참가자가 존재해야함
                boolean isInExitCheck = false;
                boolean isInPeopleCheck = false;
                for(int row = i; row <= i + distance; row++) {
                    for (int col = j; col <= j + distance; col++) {

                        System.out.println(row + " " + col + " " + arr[row][col] + " distance : " + distance);
                        // exit가 존재한다면
                        if (exitX == col && exitY == row) {
                            isInExitCheck = true;
                        }

                        if (arr[row][col] > 0) {
                            isInPeopleCheck = true;
                        }
                    }
                }

//                System.out.println();

                if(isInExitCheck && isInPeopleCheck){
                    startRow = i;
                    startCol = j;
                    break;
                }
            }
            if(startRow != -1) break;
        }

        rightRotate90(startRow, startCol, distance);
    }



    private static void rightRotate90(int row, int col, int distance){
        int[][] testCase = new int[distance + 1][distance + 1];

         System.out.println(row + " " + col + " " + distance);

        for(int i = row; i <= row + distance; i++){
            for(int j = col; j <= col + distance; j++){
                // System.out.println(i + " " + j);
                testCase[i - row][j - col] = arr[i][j];
            }
        }


        int[][] testCase2 = deepCopy(testCase);

        // System.out.println("이전");
        // for(int i = 0 ; i < distance; i++){
        //     System.out.println(Arrays.toString(testCase[i]));
        // }
        // System.out.println();

        // System.out.println("체크하는 구간");
        int disNumber = distance + 1;
        for(int i = 0; i < disNumber; i++){
            for(int j = 0; j < disNumber; j++){
                testCase[i][j] = testCase2[disNumber - j - 1][i];
            }
        }

        // for(int i = 0 ; i < distance; i++){
        //     System.out.println(Arrays.toString(testCase2[i]));
        // }
        // System.out.println();

        for(int i = row; i <= row + distance; i++){
            for(int j = col; j <= col + distance; j++){
                arr[i][j] = testCase[i - row][j - col];

                if(-9 <= arr[i][j] && arr[i][j] <= -1) arr[i][j] += 1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());
        K = Integer.parseInt(tokenizer.nextToken());

        arr = new int[N][N];

        // 벽과 빈칸 입력
        for(int i = 0; i < N; i++){
            tokenizer = new StringTokenizer(reader.readLine());
            for(int j = 0; j < N; j++){
                arr[i][j] = Integer.parseInt(tokenizer.nextToken()) * -1;
            }
        }

        // -10 : exit, -9 ~ -1 : 벽, 0 : 빈 곳, 1이상 : 사람 있는 곳
        for(int i = 0; i < M; i++){
            tokenizer = new StringTokenizer(reader.readLine());
            int row = Integer.parseInt(tokenizer.nextToken()) - 1;
            int col = Integer.parseInt(tokenizer.nextToken()) - 1;

            arr[row][col] += 1;
        }

        tokenizer = new StringTokenizer(reader.readLine());


        int row = Integer.parseInt(tokenizer.nextToken()) - 1;
        int col = Integer.parseInt(tokenizer.nextToken()) - 1;

        arr[row][col] = -10;

        // M개수가 0개 일 때까지 반복
        for(int i = 1; i <= K; i++){
             System.out.println(i + " 번째 시작");
            // 1. 참가자 조회
            move();

             printStreet();
            // 2. 회전
            rotate90();

             printStreet();
        }

        int[] exitArr = findExitXY();
        exitY = exitArr[0] + 1;
        exitX = exitArr[1] + 1;

        System.out.println(moveStreetSum);
        System.out.println(exitY + " " + exitX);

        reader.close();
    }
}