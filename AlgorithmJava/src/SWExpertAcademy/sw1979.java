package SWExpertAcademy;

import java.util.Scanner;

public class sw1979 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int tc = 0; tc < t; tc++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int answer = 0;

            int[][] arr = new int[n + 2][n + 2];

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            for (int i = 0; i < n + 2; i++) {
                int count = 0;
                for (int j = 0; j < n + 1; j++) {
                    if (arr[i][j] == 0) {
                        if (arr[i][j + 1] != arr[i][j]) {
                            count += 1;
                        }
                    } else {
                        if (arr[i][j + 1] == arr[i][j]) {
                            count += 1;
                        } else {
                            if (count == k) {
                                answer += 1;
                            }
                            count = 0;
                        }
                    }
                }

                if (count == k)
                    answer += 1;
            }

            for (int i = 0; i < n + 2; i++) {
                int count = 0;
                for (int j = 0; j < n + 1; j++) {
                    if (arr[j][i] == 0) {
                        if (arr[j + 1][i] != arr[j][i]) {
                            count += 1;
                        }

                    } else {
                        if (arr[j + 1][i] == arr[j][i]) {
                            count += 1;
                        } else {
                            if (count == k) {
                                answer += 1;
                            }
                            count = 0;
                        }
                    }
                }
                if (count == k) {
                    answer += 1;
                }

            }
            System.out.printf("#%d %d\n", tc + 1, answer);

        }


>>>>>>> 6f853b2b9a717a79d9c12e32783edf1796baf701
    }
}
