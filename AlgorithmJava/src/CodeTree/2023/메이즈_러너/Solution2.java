package 메이즈_러너;


import java.awt.*;
import java.util.*;


public class Solution2 {

    private static class Pair {
        public final int x, y;

        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    };
    static final int NM = 15;
    static int[][] maze = new int[NM][NM];
    static int N, K, moveCnt;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        input(scanner);
        int kSize = K;
        while (K-- > 0) {
            System.out.println(kSize - K + " 번째 시작");
            moveAll();
            if (isFinish()) {
                break;
            }
            rotate();
            System.out.println();

            for(int i = 1; i <= N; i++){
                System.out.println(Arrays.toString(maze[i]));
            }
        }
        output();
    }

    static void input(Scanner scanner) {
        int M;
        N = scanner.nextInt();
        M = scanner.nextInt();
        K = scanner.nextInt();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                int x = scanner.nextInt();
                maze[i][j] = -x;
            }
        }
        for (int i = 1; i <= M; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            maze[x][y]++;
        }
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        maze[x][y] = -10;
    }

    static Pair findExit() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (maze[i][j] == -10) {
                    return new Pair(i, j);
                }
            }
        }
        return null;
    }

    static final int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static void moveAll() {
        int[][] newMaze = new int[NM][NM];
        Pair ex = findExit();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (maze[i][j] < 0) {
                    newMaze[i][j] = maze[i][j];
                    continue;
                }
                if (maze[i][j] == 0) {
                    continue;
                }
                int curDist = Math.abs(i - ex.x) + Math.abs(j - ex.y);
                int minDist = curDist, minI = 0, minJ = 0;
                for (int k = 0; k < 4; k++) {
                    int ni = i + dirs[k][0];
                    int nj = j + dirs[k][1];
                    if (ni < 1 || nj < 1 || ni > N || nj > N) continue;
                    if (-9 <= maze[ni][nj] && maze[ni][nj] <= -1) continue;
                    int dist = Math.abs(ni - ex.x) + Math.abs(nj - ex.y);
                    if (minDist > dist) {
                        minDist = dist;
                        minI = ni;
                        minJ = nj;
                    }
                }
                if (minDist == curDist) {
                    newMaze[i][j] += maze[i][j];
                    continue;
                }
                moveCnt += maze[i][j];
                if (maze[minI][minJ] != -10) {
                    newMaze[minI][minJ] += maze[i][j];
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            System.arraycopy(newMaze[i], 0, maze[i], 0, N + 1);
        }
    }

    static void subRotate(int x, int y, int d) {
        int[][] a = new int[NM][NM];
        int[][] b = new int[NM][NM];
        System.out.println("rotate : " + x + " " + y + " d : " + d);
        for (int i = x; i <= x + d; i++) {
            for (int j = y; j <= y + d; j++) {
                a[i - x + 1][j - y + 1] = maze[i][j];
            }
        }
        int n = d + 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (-9 <= a[i][j] && a[i][j] <= -1) {
                    a[i][j]++;
                }
                b[j][n + 1 - i] = a[i][j];
            }
        }
        for (int i = x; i <= x + d; i++) {
            for (int j = y; j <= y + d; j++) {
                maze[i][j] = b[i - x + 1][j - y + 1];
            }
        }
    }

    static void rotate() {
        int minDist = 1000000;
        Point point = new Point();

        Pair ex = findExit();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (maze[i][j] <= 0) continue;
                int dist = Math.max(Math.abs(i - ex.x), Math.abs(j - ex.y));
                minDist = Math.min(minDist, dist);
            }
        }
        int bestRow = 0, bestCol = 0;
        for (int i = 1; i <= N - minDist; i++) {
            for (int j = 1; j <= N - minDist; j++) {
                boolean flagExit = false, flagPerson = false;
                System.out.println("i, j : " + i + " " + j + " 시작");

                for (int r = i; r <= i + minDist; r++) {
                    for (int c = j; c <= j + minDist; c++) {

                        System.out.println(r + " " + c + " " + maze[r][c] + " distance : " + minDist);
                        if (maze[r][c] == -10) flagExit = true;
                        if (maze[r][c] > 0) flagPerson = true;
                    }
                }


                if (flagExit && flagPerson) {
                    bestRow = i;
                    bestCol = j;
                    System.out.println("실행");
                    break;
                }

                System.out.println();
            }
            if (bestRow != 0) break;
        }
        subRotate(bestRow, bestCol, minDist);
    }

    static void output() {
        System.out.println(moveCnt);
        Pair ex = findExit();
        System.out.println(ex.x + " " + ex.y);
    }

    static boolean isFinish() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (maze[i][j] > 0) {
                    return false;
                }
            }
        }
        return true;
    }
}

