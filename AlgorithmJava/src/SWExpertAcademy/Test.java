package SWExpertAcademy;
import java.util.Scanner;

class swea_11315 {
    static int[] dx = { -1, -1, 0, 1, 1, 1, 0, 1 };
    static int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };
//   static int[] dx = { 1 };
//   static int[] dy = { -1 };

    public static void main(String[] args) {
        // TODO 자동 생성된 메소드 스텁
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for (int T = 1; T <= tc; T++) {
            int N = sc.nextInt();
            String st = sc.nextLine();
            char[][] arr = new char[N][N];
            for (int i = 0; i < N; i++) {
                arr[i] = (sc.nextLine()).toCharArray();
            }
            boolean answer = false;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (arr[i][j] == 'o') {
                        for (int x = 0; x < dx.length; x++) {

                            for (int xx = 1; xx < 5; xx++) {
                                int nx = i + dx[x] * xx;
                                int ny = j + dy[x] * xx;

                                if (nx < 0 || nx >= N ||  ny < 0 || ny >= N || arr[nx][ny] != 'o') {
                                    break;
                                }else if(xx == 4){
                                    answer = true;
                                }
                            }
                        }
                    }
                }
            }
            if(answer){
                System.out.printf("#%d YES\n", T);
            }else {
                System.out.printf("#%d NO\n", T);
            }
        }
    }
}
/*
 * 1 5 ....o ...o. ..o.. .o... o....
 */