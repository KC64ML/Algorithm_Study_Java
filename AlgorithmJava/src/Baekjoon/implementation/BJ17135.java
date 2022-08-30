package Baekjoon.implementation;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 캐슬 디펜스
public class BJ17135 {
    static int[][] origin, copy;
    static int N, M, D;
    static int ans;
    static boolean[] archers;

    static int[] di = {0,-1,0};
    static int[] dj = {-1,0,1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        D = sc.nextInt();

        origin = new int[N][M];
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                origin[i][j] = sc.nextInt();
            }
        } // end input

        archers = new boolean[M];
        comb(0, 0);
        System.out.println(ans);
    }

    static void comb(int idx, int cnt) {
        if(cnt == 3) { // 궁수 3명 배치됨! 게임 시뮬 돌리자!
            copy = new int[N+1][M];
            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    copy[i][j] = origin[i][j];
                }
            }

            int tmp=0;
            for(int i=0; i<N; i++) {
                tmp += bfs(copy); // 궁수들의 턴.
                move(copy); // 적들의 턴.
            }

            ans = Math.max(ans, tmp);
            return;
        }

        if(idx == M)
            return;

        archers[idx] = true;
        comb(idx+1, cnt+1);
        archers[idx] = false;
        comb(idx+1, cnt);
    }

    static void print(int[][] map) {
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
        System.out.println("-----------------");
    }

    private static void move(int[][] map) {
        for(int i=N-1; i>0; i--) {
            for(int j=0; j<M; j++) {
                map[i][j] = map[i-1][j];
            }
        }

        for(int j=0; j<M; j++) { // 애들이 다같이 한줄 내려왔으니까 맨위에는 적이 없음.
            map[0][j] = 0;
        }
    }

    private static int bfs(int[][] map) {
        boolean[][] shoot = new boolean[N][M];

        for(int j=0; j<M; j++) {
            if(archers[j]) { // 궁수 위치하는 j칸 찾았으면 bfs 시작 !
                Queue<Point> queue = new LinkedList<>(); // 이건 궁수 위치와 궁수가 탐색하는 옆칸 좌표들 들어감.
                LinkedList<Point> enemy = new LinkedList<>(); // 여기에는 적의 좌표만 넣을거임!
                boolean[][] visit = new boolean[N][M];

                queue.add(new Point(N, j));

                int dist = 0;
                while(!queue.isEmpty() && dist <= D) { // 현재 큐에 들어있는 좌표까지의 거리가 D이하인 경우에만 진행
                    int size = queue.size();

                    for(int s=0; s<size; s++) {
                        Point now = queue.poll();

                        if(map[now.i][now.j]==1) {
                            enemy.add(now);
                        }

                        for(int d=0; d<3; d++) {
                            int ni = now.i + di[d];
                            int nj = now.j + dj[d];

                            if(ni>=0 && ni<N && nj>=0 && nj<M && !visit[ni][nj]) {
                                queue.add(new Point(ni, nj));
                                visit[ni][nj] = true;
                            }
                        }
                    }

                    dist++;
                    if(!enemy.isEmpty()) { // 현재 궁수가 쏠 놈 찾았다 ! 지금 죽이면 다른 궁수가 얘를 못쏘니까 어디다 저장해놔야..음..
                        Point target = enemy.poll();
                        shoot[target.i][target.j] = true;
                        break; // 이번 궁수는 타겟 정했으니 while 끝내고 bfs 새로 시작해서 다음 궁수 타겟 찾으세염
                    }
                }
            }
        } // end for : 모든 궁수가 자신의 타겟을 찾음.

        int cnt=0;
        for(int i=0; i<N; i++) { // 궁수들이 쏘지는 않고 타겟 위치만 shoot 배열에 true 해놓음.
            for(int j=0; j<M; j++) { // 이제 쏴죽이자.
                if(shoot[i][j]) {
                    map[i][j] = 0;
                    cnt++;
                }
            }
        }

        return cnt;
    }

    static class Point implements Comparable<Point>{
        int i, j;
        Point( int i, int j){
            this.i = i;
            this.j = j;
        }

        @Override
        public int compareTo(Point o) {
            return this.j - o.j;
        }
    }
}
