package Baekjoon;

<<<<<<< HEAD
public class test {
    private static int swap3(int localA, int localB) {
        return localA;
    }

    public static void main(String[] args) {
        int a = 20, b= 5;
        b = swap3(a, a= b);
        System.out.println(a + " " + b);
    }

}
=======
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class test {

    static int N;
    static int[][] arr;
    static int midXY;
    static ArrayList<Integer>[][] accessScience;
    static ArrayList<int[]> xyStart;
    static long answer;

    static void maronmo(int x, int y, int distance, int idx) {
        int cnt = 0;
        for (int i = x - distance; i <= x; i++) {
            for (int j = y - cnt; j <= y + cnt; j++) {
                if (0 <= i && i <= 30 && 0 <= j && j <= 30) {
                    if (i != x || j != y) {
                        accessScience[i][j].add(idx);
                    }

                }
            }
            cnt += 1;
        }

        cnt = distance - 1;
        for (int i = x + 1; i <= x + distance; i++) {
            for (int j = y - cnt; j <= y + cnt; j++) {
                if (0 <= i && i <= 30 && 0 <= j && j <= 30) {
                    if (i != x || j != y) {
                        accessScience[i][j].add(idx);
                    }
                }
            }
            cnt -= 1;
        }
    }

    static void checkLoc(int x, int y) {
        for (int i = 0; i < 31; i++) {
            for (int j = 0; j < 31; j++) {
                if ((i != x || j != y) && (accessScience[i][j].size() + accessScience[x][y].size()) >= N) {
                    boolean[] visited = new boolean[N];
                    int[] distance = new int[N];
                    // 첫 번째것 검색
                    for (int in_Idx = 0; in_Idx < accessScience[x][y].size(); in_Idx++) {
                        int curIdx = accessScience[x][y].get(in_Idx);
                        visited[curIdx] = true;
                        distance[curIdx] = Math.abs(x - xyStart.get(accessScience[x][y].get(in_Idx))[0])
                                + Math.abs(y - xyStart.get(accessScience[x][y].get(in_Idx))[1]);
                        // x - xyStart.get(accessScience[x][y].get(in_Idx)][0], y -
                        // xyStart.get(accessScience[x][y].get(in_Idx)][1
                    }
                    for (int in_Idx = 0; in_Idx < accessScience[i][j].size(); in_Idx++) {

                        int curIdx = accessScience[i][j].get(in_Idx);
                        if (!visited[curIdx]) {
                            visited[curIdx] = true;
                            distance[curIdx] = Math.abs(i - xyStart.get(accessScience[i][j].get(in_Idx))[0])
                                    + Math.abs(j - xyStart.get(accessScience[i][j].get(in_Idx))[1]);
                        } else {
                            int curDate = Math.abs(i - xyStart.get(accessScience[i][j].get(in_Idx))[0])
                                    + Math.abs(j - xyStart.get(accessScience[i][j].get(in_Idx))[1]);
                            distance[curIdx] = Math.min(distance[curIdx], curDate);
                        }
                    }

                    boolean checkCurHear = false;
                    long checkSum = 0;
                    for (int checkVisit = 0; checkVisit < N; checkVisit++) {
                        if (!visited[checkVisit]) {
                            checkCurHear = true;
                            break;
                        } else
                            checkSum += distance[checkVisit];
                    }

                    // 전체 방문했을 때
                    if (!checkCurHear) {
                        answer = Math.min(answer, checkSum);
                    }
                }

            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        arr = new int[31][31];
        for (int tk = 1; tk <= T; tk++) {
            String s = br.readLine().replace(" ", "");
            N = Integer.parseInt(s);
            arr = new int[31][31];
            midXY = 30 / 2;
            accessScience = new ArrayList[31][31];
            answer = Long.MAX_VALUE;
            for (int i = 0; i < 31; i++) {
                for (int j = 0; j < 31; j++) {
                    accessScience[i][j] = new ArrayList();
                }
            }

            xyStart = new ArrayList<>();
            // 마름모를 생성해준다.
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int curX = Integer.parseInt(st.nextToken());
                int curY = Integer.parseInt(st.nextToken());
                int distance = Integer.parseInt(st.nextToken());

                xyStart.add(new int[]{midXY + curX, midXY + curY});
                arr[midXY + curX][midXY + curY] = 1;
                maronmo(midXY + curX, midXY + curY, distance, i);
            }

            // 1 확인 : 배열에 저장된 인덱스의 크기가 N일 때 확인해준다.
            for (int i = 0; i < 31; i++) {
                for (int j = 0; j < 31; j++) {
                    if (accessScience[i][j].size() == N) {
                        long checkSum = 0;
                        for (int in_drink = 0; in_drink < N; in_drink++) {
                            int drinkX = xyStart.get(in_drink)[0];
                            int drinkY = xyStart.get(in_drink)[1];

                            checkSum += Math.abs(i - drinkX) + Math.abs(j - drinkY);

                        }

                        answer = Math.min(answer, checkSum);
                    }
                }
            }

            if (answer == Long.MAX_VALUE) {
                // 2 확인 :
                for (int i = 0; i < 31; i++) {
                    for (int j = 0; j < 31; j++) {
                        if (accessScience[i][j].size() > 0) {
                            checkLoc(i, j);
                        }
                    }
                }
            }

            System.out.printf("#%d ", tk);
            if (answer == Long.MAX_VALUE) {
                System.out.println(-1);
            } else {
                System.out.println(answer);
            }

        }

        br.close();
    }
}

>>>>>>> 9de5668e6e1a777ac8b5c28b15ea349513d54b9c
