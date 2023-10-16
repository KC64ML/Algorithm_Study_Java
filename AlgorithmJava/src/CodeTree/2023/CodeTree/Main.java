package CodeTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
public class Main {
    static class Robot{
        int id;
        int r, c, h, w;
        int initK, k;

        public Robot(int id, int r, int c, int h, int w, int k) {
            super();
            this.id = id;
            this.r = r;
            this.c = c;
            this.h = h;
            this.w = w;
            this.initK = this.k = k;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int L, N, Q;
    static int[][] map;
    static int[][] robotMap;

    static Robot[] robots;
    static int robotID, robotD;
    static List<Integer> moveRobot;

    public static void main(String[] args) throws Exception{

        init();
        pro();
    }
    private static void pro() throws Exception {
        for(int i = 1; i <= Q; ++i) {
            st = new StringTokenizer(br.readLine());

            robotID = Integer.parseInt(st.nextToken());
            robotD = Integer.parseInt(st.nextToken());

            Robot robot = robots[robotID];

            // 1. 죽은 로봇은 명령 X
            if(robot.k <= 0) continue;

            // 2. 로봇이 이동 가능한지 판단
            moveRobot = new LinkedList<>();
            moveRobot.add(robotID);
            if(!isMove()) continue;

            // 3. 로봇 좌표 갱신
            updateRobot();

            // 4. 트랩 체크
            getDamage();

            // 5. 로봇 맵 갱신
            initRobotMap();

        }

        // 6. 생존한 로봇들이 총 받은 대미지의 합
        System.out.println(calcTotalDamage());
    }
    private static int calcTotalDamage() {
        int ans = 0;
        for(int i = 1; i <= N; ++i) {
            Robot robot = robots[i];

            // 죽은 로봇은 제외
            if(robot.k <= 0) continue;

            ans += robot.initK - robot.k;

        }

        return ans;
    }
    private static void getDamage() {

        for(int id : moveRobot) {

            // 명령을 받은 로봇은 피해 X
            if(id == robotID) continue;
            Robot robot = robots[id];

            int r = robot.r;
            int c = robot.c;
            int h = robot.h;
            int w = robot.w;

            for(int i = r; i < r + h; ++i) {
                for(int j = c; j < c + w; ++j) {
                    if(map[i][j] == 1) --robot.k;
                }
            }
        }
    }
    private static void updateRobot() {
        for(int id : moveRobot) {
            Robot robot = robots[id];

            robot.r += dx[robotD];
            robot.c += dy[robotD];
        }

    }
    private static boolean isMove() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(robotID);

        boolean[] checkedRobot = new boolean[N+1];
        checkedRobot[robotID] = true;

        while(!q.isEmpty()) {

            int id = q.poll();
            Robot robot = robots[id];
            int r = robot.r;
            int c = robot.c;
            int h = robot.h;
            int w = robot.w;
            // 각 방향에 따라 로봇의 다음 위치 판단
            // 1. 위쪽
            if(robotD == 0) {
                for(int j = c; j < c + w; ++j) {
                    // 이동하려는 방향에 벽이 있는지 판단
                    if(map[r-1][j] == 2) return false;

                    // 이동하려는 방향에 다른 로봇이 있는지 판단
                    int v = robotMap[r-1][j];
                    if(v != 0 && !checkedRobot[v]) {
                        q.offer(v);
                        moveRobot.add(v);
                        checkedRobot[v] = true;
                    }
                }
            }
            // 2. 오른쪽
            else if(robotD == 1) {
                for(int i = r; i < r + h; ++i) {
                    // 이동하려는 방향에 벽이 있는지 판단
                    if(map[i][c + w] == 2) return false;

                    // 이동하려는 방향에 다른 로봇이 있는지 판단
                    int v = robotMap[i][c + w];
                    if(v != 0 && !checkedRobot[v]) {
                        q.offer(v);
                        moveRobot.add(v);
                        checkedRobot[v] = true;
                    }
                }
            }
            //3. 아래쪽
            else if(robotD == 2) {
                for(int j = c; j < c + w; ++j) {
                    // 이동하려는 방향에 벽이 있는지 판단
                    if(map[r + h][j] == 2) return false;

                    // 이동하려는 방향에 다른 로봇이 있는지 판단
                    int v = robotMap[r + h][j];
                    if(v != 0 && !checkedRobot[v]) {
                        q.offer(v);
                        moveRobot.add(v);
                        checkedRobot[v] = true;
                    }
                }
            }
            // 4. 왼쪽
            else if(robotD == 3) {
                for(int i = r; i < r + h; ++i) {
                    // 이동하려는 방향에 벽이 있는지 판단
                    if(map[i][c - 1] == 2) return false;

                    // 이동하려는 방향에 다른 로봇이 있는지 판단
                    int v = robotMap[i][c - 1];
                    if(v != 0 && !checkedRobot[v]) {
                        q.offer(v);
                        moveRobot.add(v);
                        checkedRobot[v] = true;
                    }
                }
            }
            // End : 각 방향에 따라 로봇의 다음 위치 판단

        }

        return true;
    }



    private static void init() throws Exception{

        st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        // 1. 맵
        map = new int[L+2][L+2];
        Arrays.fill(map[0], 2);
        Arrays.fill(map[L+1], 2);

        for(int i = 1; i <= L; ++i) {

            map[i][0] = map[i][L+1] = 2;

            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= L; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 2. 로봇
        robots = new Robot[N+1];
        for(int i = 1; i <= N; ++i) {
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            robots[i] = new Robot(i, r, c, h, w, k);
        }

        // 3. 로봇 맵
        initRobotMap();

    }
    private static void initRobotMap() {

        robotMap = new int[L+2][L+2];
        for(int id = 1; id <= N; ++id) {
            Robot robot = robots[id];
            // 체력없는 로봇은 제외
            if(robot.k <= 0) continue;

            int r = robot.r;
            int c = robot.c;
            int h = robot.h;
            int w = robot.w;

            for(int i = r; i < r + h; ++i) {
                for(int j = c; j < c + w; ++j) {
                    robotMap[i][j] = id;
                }
            }
        }

    }
}
