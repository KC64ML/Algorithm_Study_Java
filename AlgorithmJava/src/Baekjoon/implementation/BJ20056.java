package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class NoddeIn20056{
    int m; // 질량
    int s; // 속력
    int d; // 방향
    // 파이어볼 방향, 8인경우 : 0, 2, 4, 6
    // 9인 경우 : 1, 3, 5, 7

    int fireCnt;

    boolean check;


    public NoddeIn20056() {
    }

    public NoddeIn20056(int m, int s, int d, int f, boolean check) {
        this.m = m;
        this.s = s;
        this.d = d;
        this.fireCnt = f;
        this.check = check;
    }

}

class Nodde20056{
    int m; // 질량
    int s; // 속력
    int d; // 방향
    // 파이어볼 방향, 8인경우 : 0, 2, 4, 6
    // 9인 경우 : 1, 3, 5, 7

    int fireCnt;


    public Nodde20056() {
    }

    public Nodde20056(int m, int s, int d, int f) {
        this.m = m;
        this.s = s;
        this.d = d;
        this.fireCnt = f;
    }

}

public class BJ20056 {

    static int N, M, K;
    static int[][] direct = {{0, 1}, {1, 1}, {1, 0}, {1, -1},
            {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}}; // 방향

    static Nodde20056[][] node;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        node = new Nodde20056[N+1][N+1];


        for(int i=0; i< N+1;i++){
            for(int j=0; j< N+1;j++){
                node[i][j] = new Nodde20056(0,0,0,0);
            }
        }

        for(int i =0; i<M; i++){
            int r,c,m,s,d;
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            s = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());

            node[r][c].d = d;
            node[r][c].s = s;
            node[r][c].m = m;
            node[r][c].fireCnt = 1;
        }


        for(int tk = 1; tk <= K; tk++){
            NoddeIn20056[][] curResult = new NoddeIn20056[N+1][N+1];

            for(int i=0; i< N+1;i++){
                for(int j=0; j< N+1;j++){
                    curResult[i][j] = new NoddeIn20056(0,0,0,0, false);
                }
            }


            // 2차 배열 확인
            for(int i =1; i <=N ;i++){
                for(int j=1; j<=N; j++){
                    if(node[i][j].fireCnt == 1){
                        int nextX = (i + direct[node[i][j].d][0] * node[i][j].s) % N;
                        int nextY = (j + direct[node[i][j].d][1] * node[i][j].s) % N;

                        // 도착한 노드의 개수가 2이상이라면 홀, 짝 체크한다.
                        if(curResult[nextX][nextY].fireCnt == 0){
                            curResult[nextX][nextY].m = node[i][j].m;
                            curResult[nextX][nextY].s = node[i][j].s;
                            curResult[nextX][nextY].fireCnt = node[i][j].fireCnt;
                            curResult[nextX][nextY].d = node[i][j].d;
                            // ture, false
                            curResult[nextX][nextY].check = true;
                        }else if(curResult[nextX][nextY].fireCnt >= 1){
                            // 1이상인데 추가된 경우, 2개이상의 파이어볼이 합쳐진 것
                            curResult[nextX][nextY].m += node[i][j].m;
                            curResult[nextX][nextY].s += node[i][j].s;
                            curResult[nextX][nextY].fireCnt += node[i][j].fireCnt;
                            curResult[nextX][nextY].d = node[i][j].d;
                            // 홀 수 이면 false, 짝수이면 true
                            if(curResult[nextX][nextY].check){
                                if(curResult[nextX][nextY].d  % 2 == 0 && node[i][j].d % 2 ==0) curResult[nextX][nextY].check = true;
                                else if(curResult[nextX][nextY].d  % 2 != 0 && node[i][j].d % 2 !=0) curResult[nextX][nextY].check = true;
                            }else{
                                curResult[nextX][nextY].check = false;
                            }
                        }
                    } else if () {
                        // 2이상인 경우 체크한다.

                    }
                }
            }
        }



        br.close();
    }
}
