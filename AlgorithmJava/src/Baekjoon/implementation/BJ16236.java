package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ16236 {
    static int N;
    static int[][] place;
    static int sharkX, sharkY, sharkForce, sharkEat;
    static boolean[][] visited;
    static int answer;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0 , -1};

    static boolean bfs(){

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{sharkX, sharkY});
        visited = new boolean[N][N];
        System.out.println(sharkX + " " + sharkY);
        visited[sharkX][sharkY] = true;
        int feed_i = N, feed_j = N;
        int dist = 0;

        while(queue.size() > 0){
            int[] res = queue.poll();
            for(int i = 0; i <4; i++){
                int nx = dx[i] + res[0];
                int ny = dy[i] + res[1];

                if(0 <= nx && nx < N && 0<=ny && ny < N && place[nx][ny] <= sharkForce){
                    if(visited[nx][ny]) continue;

                    if((place[nx][ny] == 0 ||  place[nx][ny] == sharkForce)  && !visited[nx][ny]){
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                    }else if(place[nx][ny] < sharkForce && place[nx][ny] > 0){
                        // 위쪽에 있는 것을 찾는다.
                        if (nx < feed_i) {
                            feed_i = nx;
                            feed_j = ny;
                        }else if(nx == feed_i){
                            sharkX = Math.min(nx, sharkX);
                        }

                    }
                }
            }

            dist++;
            if(feed_i < N && feed_j < N){
                sharkX = feed_i;
                sharkY = feed_j;
                place[sharkX][sharkY] = 0;
                sharkEat++;
                if(sharkForce == sharkEat){
                    sharkForce += 1;
                    sharkEat = 0;
                }
                answer += dist;
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        place = new int[N][N];

        StringTokenizer st;
        for(int i = 0; i< N ;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j <N;j++){
                place[i][j] = Integer.parseInt(st.nextToken());
                if(place[i][j] == 9){
                    sharkX = i;
                    sharkY = j;
                    sharkForce = 2; // 기본 힘 2
                }
            }
        }



        while(true){
            if(!bfs()){
                break;
            }
        }

        System.out.println(answer);

        br.close();
    }
}
