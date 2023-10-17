package CodeTree;

import java.util.*;
import java.io.*;

public class Main {

    private static class Attacker{
        private final int index;
        public final int r;
        public final int c;
        public final int h;
        public final int w;
        public final int k;

        Attacker(int index, int r, int c, int h, int w, int k){
            this.index = index;
            this.r = r;
            this.c = c;
            this.h = h;
            this.w = w;
            this.k = k;
        }

        public void inputAttackerArr(int[][] attackerIndexArr){
            if(k <= 0) return;
            for(int row = r; row < r + h; row++){
                for(int col = c; col < c + w; col++){
                    attackerIndexArr[row][col] = index;
                }
            }
        }
        public Attacker move(int directionRow, int directionCol){
            return new Attacker(index, r + directionRow, c + directionCol, h, w, k);
        }
        public Attacker damage(int[][] tree){
            int curK = k;
            for(int row = r; row < r + h; row++){
                for(int col = c; col < c + w; col++){
                    if(tree[row][col] == 1) curK--;
                }
            }

            curK = Math.max(curK, 0);
            return new Attacker(index, r, c, h, w, curK);
        }
    }
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer tokenizer;

    private static int L, N, Q;
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {-1, 0, 1, 0};
    private static int[] result;

    // 빈칸, 함정, 벽 좌표
    private static int[][] tree;

    // 기사 정보
    private static Attacker[] attackers;

    private static void input() throws IOException{

        tokenizer = new StringTokenizer(reader.readLine());
        L = Integer.parseInt(tokenizer.nextToken());
        N = Integer.parseInt(tokenizer.nextToken());
        Q = Integer.parseInt(tokenizer.nextToken());

        tree = new int[L + 1][L + 1];
        result = new int[N + 1];
        attackers = new Attacker[N + 1];

        for(int i = 1; i <= L; i++){
            tokenizer = new StringTokenizer(reader.readLine());
            for(int j = 1; j <= L; j++){
                tree[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        for(int i = 1; i <= N; i++){
            tokenizer = new StringTokenizer(reader.readLine());
            int r = Integer.parseInt(tokenizer.nextToken());
            int c = Integer.parseInt(tokenizer.nextToken());
            int w = Integer.parseInt(tokenizer.nextToken());
            int h = Integer.parseInt(tokenizer.nextToken());
            int k = Integer.parseInt(tokenizer.nextToken());

            attackers[i] = new Attacker(i, r, c, w, h, k);
            result[i] = k;
        }
    }

    private static boolean isWithInRange(int row, int col){
        if(1 <= row && 1 <= col && row <= L && col <= L) return true;
        else return false;
    }

    private static void move(int index, int d){
        if(attackers[index].k <= 0) return;
        int[][] attackerIndexArr = new int[L + 1][L + 1];
        boolean[] moveAttacker = new boolean[N + 1];

        for(int i = 1; i <= N; i++){
            // attackerIndexArr에 인덱스 저장
            attackers[i].inputAttackerArr(attackerIndexArr);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(index);
        moveAttacker[index] = true;
        while(!queue.isEmpty()){
            int curIndex = queue.poll();

            for(int row = attackers[curIndex].r; row < attackers[curIndex].r + attackers[curIndex].h; row++){
                for(int col = attackers[curIndex].c; col < attackers[curIndex].c + attackers[curIndex].w; col++){
                    int curRow = row + dy[d];
                    int curCol = col + dx[d];

                    if(!isWithInRange(curRow, curCol)) return;

                    // 0으로 이동할 수 있지만, 벽이 존재하는 경우 이동할 수 없다.
                    if(attackerIndexArr[curRow][curCol] == 0){
                        if(tree[curRow][curCol] == 2){
                            return;
                        }
                        continue;
                    }

                    if(!moveAttacker[attackerIndexArr[curRow][curCol]]){
                        moveAttacker[attackerIndexArr[curRow][curCol]] = true;
                        queue.add(attackerIndexArr[curRow][curCol]);
                    }
                }
            }
        }


        for(int i = 1; i <= N; i++){
            if(!moveAttacker[i]) continue;

            attackers[i] = attackers[i].move(dy[d], dx[d]);

            if(i == index) continue;
            attackers[i] = attackers[i].damage(tree);
        }

    }

    private static void printArr(int[][] arr){
        for(int i = 1; i <= L; i++){
            for(int j = 1; j <= L; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    private static void pro() throws IOException{

        for(int i = 1; i <= Q; i++){
            tokenizer = new StringTokenizer(reader.readLine());
            int index = Integer.parseInt(tokenizer.nextToken());
            int direction = Integer.parseInt(tokenizer.nextToken());

            move(index, direction);
        }

        int answer = 0;
        for(int i = 1; i <= N; i++){
            if(attackers[i].k == 0) result[i] = 0;
            else{
                result[i] -= attackers[i].k;
                answer += result[i];
            }
        }

        System.out.println(answer);

    }
    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
