package 메이즈_러너;

import java.io.*;
import java.util.*;

public class Solution {

    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static int N;

    private static boolean isWithInRange(int x, int y, int index){
        if(index <= x && index <= y && x < N - index && y < N - index) return true;
        else return false;
    }

    private static int swap(int a , int b){
        return a;
    }

    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());
        int[][] arr = new int[N][N];

        int count = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                arr[i][j] = ++count;
            }
        }

        for(int[] inArr : arr){
            System.out.println(Arrays.toString(inArr));
        }
        int size = (arr.length / 2) ;

        int startX = 0;
        int startY = 0;

        for(int i = 0; i < size; i++){
            int curX = startX + i;
            int curY = startY + i;
            int beforeData = arr[curY][curX];
            int d = 0;

            while(true){
                int nx = curX + dx[d];
                int ny = curY + dy[d];
//                System.out.println("삽입" + " nx : " + nx + " ny : " + ny + " d : " + d);
                // 범위를 벗어나거나 처음 위치라면
                if(!isWithInRange(nx, ny, i)){
                    d = (d + 1) % 4;
                    nx = curX + dx[d];
                    ny = curY + dy[d];
                }

                // 처음 시작 위치라면
                if(nx == (startX + i)  && ny == (startY + i)){
                    arr[ny][nx] = beforeData;
                    break;
                }else{
//                    System.out.println("i : " + i + " nx : " + nx + " ny : " + ny + " d : " + d + " startX : " + (startX+ i) + " startY : " + (startY+ i));
                    beforeData = swap(arr[ny][nx], arr[ny][nx] = beforeData);
                    curX = nx;
                    curY = ny;
                }
            }

        }
        for(int[] inArr : arr){
            System.out.println(Arrays.toString(inArr));
        }

    }
}
