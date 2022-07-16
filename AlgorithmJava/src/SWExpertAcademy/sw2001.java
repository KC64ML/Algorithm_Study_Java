package SWExpertAcademy;

import java.io.*;
import java.util.StringTokenizer;

public class sw2001 {
    static int[][] arr;

    public static int sumFunction(int x, int y, int m) {
        int sum = 0;

        for (int i = x; i < x + m; i++) {
            for (int j = y; j < y + m; j++) {
                sum += arr[i][j];
            }
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int n = Integer.parseInt(br.readLine());


        for (int tr = 0; tr < n; tr++) {
            int[] sol = new int[n];

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < 2; i++) {
                sol[i] += Integer.parseInt(st.nextToken());
            }

            arr = new int[sol[0] + 1][sol[0] + 1];

            for (int i = 0; i < sol[0]; i++) {
                String[] s = br.readLine().split(" ");
                for (int j = 0; j < sol[0]; j++) {
                    arr[i][j] = Integer.parseInt(s[j]);
                }
            }

            int cur_result = 0;
            int answer = 0;

            for (int i = 0; i < sol[0] - sol[1] + 1; i++) {
                for (int j = 0; j < sol[0] - sol[1] + 1; j++) {
                    cur_result = sumFunction(i, j, sol[1]);

                    if (answer < cur_result) {
                        answer = cur_result;
                    }
                }
            }

            System.out.printf("#%d %d\n", tr + 1, answer);
        }


        br.close();
    }
}
