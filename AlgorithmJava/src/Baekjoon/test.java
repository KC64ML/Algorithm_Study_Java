package Baekjoon;

import Baekjoon.implementation.BJ16236;

import java.util.*;



import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class test {
    static int shark_i, shark_j, shark_w, shark_eat; // 상어좌표 i,j 상어크기w 현재 먹은 먹이eat(성장하면 초기화)
    static int[] di = { 0, 0, 1, -1 };
    static int[] dj = { 1, -1, 0, 0 };

    static int N; // 지도 크기
    static int[][] map; // 물고기 정보 지도
    static boolean[][] visit; // bfs 탐색할 때 큐에 들어간 좌표 또 안들어가게

    static int ans; // 아기 상어가 살아남은 총 시간

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 9) { // 초기 상어 위치
                    shark_i = i;
                    shark_j = j;
                    shark_w = 2; // 초기 크기 2
                    map[i][j] = 0; // 지도에 있는 상어 공중부양.
                }
            }
        } // end input

        while (true) {
            boolean result = bfs(); // 상어 현재 위치에서 먹을 수 있는 먹이 있나? 있으면 먹어야지
            if (!result) // 먹이 못먹었어 ? 먹을수 있는게 없나보네 .. 엄마한테 가라
                break;
        }
        System.out.println(ans);
    }

    static boolean bfs() {
        Queue<Point> queue = new LinkedList<>(); // 이동 스케줄
        visit = new boolean[N][N];

        queue.add(new Point(shark_i, shark_j));
        visit[shark_i][shark_j] = true;

        int dist = 0; // 먹이까지의 거리
        int feed_i = N, feed_j = N; // 먹이 있다없다 + 위치 체크 변수 (i, j가 더 작아질수록 위,왼쪽에 있는 거임.)
        while (!queue.isEmpty()) { // 상어가 이동가능한 후보칸이 남아있는한 계속 탐색
            int size = queue.size(); // 현재 이동스케줄 몇개있나 보자!(출발점에서 같은 거리에 있는 스케줄 갯수)

            for (int s = 0; s < size; s++) {
                Point now = queue.poll();
                for (int d = 0; d < 4; d++) {
                    int nexti = now.i + di[d];
                    int nextj = now.j + dj[d];
                    if(nexti<0 || nexti>=N || nextj<0 || nextj>=N || map[nexti][nextj]>shark_w) continue; // 이동 불가
                    else if((map[nexti][nextj]==0 || map[nexti][nextj]==shark_w)&&!visit[nexti][nextj]) { // 이동만 가능
                        queue.add(new Point(nexti, nextj));
                        visit[nexti][nextj] = true;
                    }else if(map[nexti][nextj]<shark_w && map[nexti][nextj]>0) { // 먹이다!!!!
                        if(nexti<feed_i) { // 높이가 위면 무조건 먹는게 좋징
                            feed_i = nexti;
                            feed_j = nextj;
                        }else if(nexti == feed_i) { // 기존에 찾아놓은 다른 먹이랑 높이 같으면 더 왼쪽!
                            feed_j = Math.min(nextj, feed_j);
                        }
                    }
                }
            } // 같은 거리에 있는 좌표 뺐으면 큐에 좌표 남았어도 일단 정지

            // 먹이 없었으면 그냥 계속 진행인데 먹이가 있으면?! 먹어야됨! 여러개면 ?! 위, 왼쪽을 골라야함!
            dist++;
            if (feed_i < N && feed_j < N) { // 먹이가 있었네?!
                shark_i = feed_i;
                shark_j = feed_j;
                map[shark_i][shark_j] = 0;
                shark_eat++; // 상어가 먹이 먹음.
                if(shark_eat == shark_w) { // 충분히 먹어서 성장!
                    shark_w++;
                    shark_eat=0;
                }
                ans += dist; // 먹이한테 가는 거리(시간)
                return true;
            }
        } // end while

        return false;
    }

    static class Point {
        int i, j;

        Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}

