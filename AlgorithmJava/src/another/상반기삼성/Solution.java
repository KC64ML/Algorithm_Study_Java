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
    static int dist[][];
    static int dir[][] = {{0,1},{-1, 0}, {1, 0}, {0, -1}};

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

    static void bfs(int startX, int startY){
        for(int i = 1; i <= n; i++) for(int j = 1; j <= n; j++)  dist[i][j] = 100000;

        Queue<Integer> queue = new ArrayDeque<Integer>();
        queue.add(startX);
        queue.add(startY);
        dist[startX][startY] = 0;

        while(queue.size() > 0){
            int curX = queue.poll();
            int curY = queue.poll();

            for(int i = 0; i < 4; i++){
                int nx = curX + dir[i][0];
                int ny = curY + dir[i][1];

                if(!(1 <= nx & nx <=n && 1<= ny && ny <= n)) continue;
                if(dist[nx][ny] != 100000) continue; // 이미 방문했기 때문에
                if(graph[nx][ny] == -1) continue;
                dist[nx][ny] = dist[curX][curY] + 1;
                queue.add(nx);
                queue.add(ny);
            }
        }
    }

    static boolean isArrived(int idx){
        return codeTree[idx].curX == codeTree[idx].goalX && codeTree[idx].curY == codeTree[idx].curY;
    }

    static void movePerson(int idx){
        if(isArrived(idx)) return;

        // 현재 위치를 기준으로 이동
        bfs(codeTree[idx].goalX, codeTree[idx].goalY);

        int minDist = 10000, minDir = -1;
        System.out.println(codeTree[idx].curX + " " + codeTree[idx].curY);
        // 상좌우하로 한번씩 조히한다.
        for(int i = 0; i < 4; i++){
            int nx = dir[i][0] + codeTree[idx].curX;
            int ny = dir[i][1] + codeTree[idx].curY;
            System.out.println("nx, ny : " + nx + " " + ny);
            if(!(1 <= nx && nx <= n && 1 <= ny && ny <=n)) continue;
            System.out.println("minDist : " + dist[nx][ny]);
            System.out.println("minDist : " + minDist + " dist : " + dist[nx][ny]);
            if(dist[nx][ny] < minDist){
                minDist = dist[nx][ny];
                minDir = i;
            }
        }

        // 새로운 방향으로 업데이트
        codeTree[idx].curX += dir[minDir][0];
        codeTree[idx].curY += dir[minDir][1];
    }

    static void initiate(int time){
        // 방문했는지 확인하기 (현재 도착지점을 기점으로 거리 구함)
        bfs(codeTree[time].goalX, codeTree[time].goalY);

        // 가장 가까운 베이스 찾기
        int minDist = 10000, minI = 0, minJ = 0;
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= m; j++){
                // 베이스캠프가 아닌 위치는 무시
                if(graph[i][j] != 1) continue;
                if(dist[i][j] < minDist){
                    minDist = dist[i][j];
                    minI = i;
                    minJ = j;
                }
            }
        }

        codeTree[time].curX = minI;
        codeTree[time].curY = minJ;
        graph[minI][minJ] = -1;

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
        dist = new int[n+1][n+1];

        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 도착지 편의점 위치 저장
        for(int i = 1; i <= m; i++){
            st = new StringTokenizer(br.readLine());
            codeTree[i] = new CodeTree();
            codeTree[i].goalX = Integer.parseInt(st.nextToken());
            codeTree[i].goalY = Integer.parseInt(st.nextToken());
            System.out.println(codeTree[i].goalX);
        }

        pro();

        br.close();
    }
}