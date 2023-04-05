package another.상반기삼성;

import java.util.*;
import java.io.*;

class CodeTree {
    int curX, curY;
    int goalX, goalY;
}

public class Solution {
    static int n, m;
    static CodeTree[] codeTree;
    static int graph[][];

    // 모두 도착했는지 확인
    static boolean isFinished() {
        for(int i = 1; i <= m; i++){
            if(codeTree[i].curX != codeTree[i].goalX ||
                    codeTree[i].curY != codeTree[i].goalY) return false;
        }
        return true;
    }
    static void checkArrived(int idx){
        if(codeTree[idx].curX == codeTree[idx].goalX &&
                codeTree[idx].curY == codeTree[idx].goalY){
            graph[codeTree[idx].curX][codeTree[idx].curY] = -1;
        }
    }

    static void bfs(){

    }

    static void movePerson(int idx){
        // 현재 위치를 기준으로 이동
    }

    static void initiate(int time){
        // 방문했는지 확인하기

    }

    static void pro(){
        int time = 0;
        // 현재 모든 사용자가 목적지에 도착했는지 확인한다.
        while(!isFinished()){
            time++;
            // (1) 모든 사용자 현재 위치에서 자리 이동한다.
            for(int i = 1; i < time && i <= m; i++){
                movePerson(i);
            }

            // (2) 방문한 곳인지 확인한다.
            for(int i = 1; i < time && i <= m ; i++){
                // 도착했으면 연락 요청
                checkArrived(i);
            }

            if(time <= m){
                initiate(time);
            }
        }
    }

    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        // 격자의 크기 : n, 사람의 수 : m
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        codeTree = new CodeTree[m+1];

        // 1 : 베이스캠프 (도착하기전), 지나간 경우 : -1
        // 0 : 빈공간
        // 2 : 편의점, 지나간 경우 : -1
        graph = new int[n + 1][n + 1];

        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 도착지 편의점 위치 저장
        for(int i = 1; i <= m; i++){
            st = new StringTokenizer(br.readLine());
            codeTree[i].goalX = Integer.parseInt(st.nextToken());
            codeTree[i].goalY = Integer.parseInt(st.nextToken());
        }

        pro();

        br.close();
    }
}