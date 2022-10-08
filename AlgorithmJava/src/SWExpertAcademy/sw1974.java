package SWExpertAcademy;

import java.io.*;
import java.util.*;

public class sw1974 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 1; i <= t; i++) {
            int answer = 1;
            int[][] arr = new int[10][10];
            for (int row = 1; row <= 9; row++) {
                final StringTokenizer st = new StringTokenizer(br.readLine());
                for (int col = 1; col <= 9; col++) {
                    arr[col][row] = Integer.parseInt(st.nextToken());
                }
            }

            // 행과 열 중 적어도 하나라도 아닌지 체크하기
//            System.out.println("행과 열 확인");
            for (int r = 1; r < 10; r++) {
                boolean[] rcheck = new boolean[10];
                boolean[] ccheck = new boolean[10];
                for (int c = 1; c < 10; c++) {
                    rcheck[arr[r][c]] = true;
                    ccheck[arr[c][r]] = true;
                }
                boolean check = true;

                for (int k = 1; k < 10; k++) {
                    if (!rcheck[k]) {
                        check = false;
                        break;
                    }
                    if(!ccheck[k]){
                        check =false;
                        break;
                    }
                }

                if (!check) {
                    answer = 0;
                    break;
                }
            }

            if (answer == 0) {
                System.out.println("#" + i + " 0");
                continue;
            }

            // 3 x 3 정사각형
//            System.out.println("3 x 3 정사각형");
            for (int r = 1; r < 10; r+=3) {
                for (int c = 1; c < 10; c+=3) {
                    boolean[] checkarr = new boolean[10];
                    for (int x = 0; x < 3; x++)
                        for (int y = 0; y < 3; y++)
                            checkarr[arr[r+x][c+y]] = true;

                    boolean check = true;

                    for (int k = 1; k < 10; k++) {
                        if (!checkarr[k]) {
                            check = false;
                            break;
                        }
                    }
                    if (!check) {
                        answer = 0;
                        break;
                    }
                }
                if (answer == 0) break;
            }
            System.out.println("#" + i + " " + answer);
        }
        br.close();
    }


}
