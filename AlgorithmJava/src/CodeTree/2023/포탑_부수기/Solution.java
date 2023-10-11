package 포탑_부수기;

import java.io.*;
import java.util.*;



public class Solution {

    private static class Node{
        public final int x;
        public final int y;

        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    private static int N, M, K;
    private static int[][] attackArr;
    private static int[][] timeArr;

    private static void selectionAttack(){
        int minAttackY = 0;
        int minAttackX = 0;
        ArrayList<Node> list = new ArrayList<>();
        list.add(new Node(minAttackY, minAttackX));

        // (1) 공격력이 가장 낮은 포탑 List에 저장
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(attackArr[i][j] < attackArr[minAttackY][minAttackX]){
                    minAttackX = j;
                    minAttackY = i;
                    list.clear();
                    list.add(new Node(j, i));
                }else if(attackArr[i][j] == attackArr[minAttackY][minAttackX]){
                    list.add(new Node(j, i));
                }
            }
        }

        // size가 1인 경우 종료
        if(list.size() == 1) return new int[]{minAttackX, minAttackY};

        // (2) 포탑 List가 여러 개인 경우 (가장 최근에 추가한 포탑)
        ArrayList<Node> list2 = new ArrayList<>();
        list2.add(minAttackX);
        list2.add(minAttackY);

        for(int i = 1; i < list.size(); i++){
            if(timeArr[list.get(i).y][list.get(i).x] < timeArr[minAttackY][minAttackX]){
                list2.clear();
                minAttackX = list.get(i).x;
                minAttackY = list.get(i).y;
                list2.add(new Node(j, i));
            }else if(timeArr[list.get(i).y][list.get(i).x] == timeArr[minAttackY][minAttackX]){
                list2.add(new Node(j, i));
            }
        }

        if(list2.size() == 1) return new int[]{minAttackX, minAttackY};

        // (3), (4) 그런데도 List가 여러개 인경우 (행열 합이 큰것, 같으면 열 기준)
        for(Point p : list2){
            if(p.x + p.y )
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());
        K = Integer.parseInt(tokenizer.nextToken());

        for(int i = 0; i < N; i++){
            tokenizer = new StringTokenizer(reader.readLine());
            for(int j = 0; j < M; j++){
                attackArr[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        // (1)
        selectionAttack();

        reader.close();
    }
}
