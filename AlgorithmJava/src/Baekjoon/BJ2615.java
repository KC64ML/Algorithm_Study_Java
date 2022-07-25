package Baekjoon;

import java.util.*;
import java.io.*;

public class BJ2615 {

    static boolean visited[][][] = new boolean[19][19][4];
    static int[][] arr = new int[19][];
    static int answer1, answer2 = -1, answer3 = -1;

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int cnt = 0;
        for (int i = 0; i < 19; i++) {
            final StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = new int[19];
            for (int j = 0; j < 19; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (arr[i][j] == 1 || arr[i][j] == 2) {
                    // 직선 확인한다.
                    if (visited[i][j][0] == false) {
//						System.out.printf("현재 좌표 방문 : %d, %d\n",i,j);
                        cnt = 1;
                        for (int z = 1; z + j < 19; z++) {
                            if(arr[i][z+j] == arr[i][j]) {
//								System.out.printf("->현재 좌표 : %d, %d %d\n",i,z+j, cnt);
                                cnt += 1;
                                visited[i][z+j][0] = true;
                            }else {
                                break;
                            }
                        }
//						System.out.println();

                        if(cnt == 5) {
                            answer1 = arr[i][j];
                            answer2 = i;
                            answer3 = j;
                            break;
                        }
                    }

                    
                    // 대각선 밑을 확인한다.
                    if (visited[i][j][1] == false) {
                        cnt = 1;
                        for (int z = 1; z + j < 19 && z + i < 19; z++) {
                            if(arr[z+i][z+j] == arr[i][j]) {
//								System.out.printf("대각선아래->현재 좌표 : %d, %d %d\n",z+i,z+j, cnt);
                                cnt += 1;
                                visited[z+i][z+j][1] = true;
                            }else {
                                break;
                            }
                        }
//						System.out.println();
                        if(cnt == 5) {
                            answer1 = arr[i][j];
                            answer2 = i;
                            answer3 = j;
                            break;
                        }
                    }

                    // 밑을 확인한다.
                    if (visited[i][j][2] == false) {
                        cnt = 1;
                        for (int z = 1; z + i < 19; z++) {
                            if(arr[z+i][j] == arr[i][j]) {
//								System.out.printf("밑에-> 현재 좌표 : %d, %d %d\n",z+i,j,cnt);
                                cnt += 1;
                                visited[z+i][j][2] = true;
                            }else {
                                break;
                            }
                        }

//						System.out.println();

                        if(cnt == 5) {
                            answer1 = arr[i][j];
                            answer2 = i;
                            answer3 = j;
                            break;
                        }
                    }


                    // 왼쪽 밑을 확인한다.
                    if(visited[i][j][3] == false) {
                        cnt = 1;
                        for (int z = 1; z + i < 19 && j - z >=0; z++) {
                            if(arr[i+z][j-z] == arr[i][j]) {
//								System.out.printf("밑에-> 현재 좌표 : %d, %d %d\n",z+i,j,cnt);
                                cnt += 1;
                                visited[i+z][j-z][3] = true;
                            }else {
                                break;
                            }
                        }

//						System.out.println();

                        if(cnt == 5) {
                            answer1 = arr[i][j];
                            answer2 = i + 4;
                            answer3 = j - 4;
                            break;
                        }
                    }

                }
            }
            if(cnt == 5) {
                break;
            }

        }


        System.out.println(answer1);
        if(answer2 != -1 && answer3 != -1) {
            System.out.printf("%d %d",answer2+1, answer3+1);
        }

    }

}