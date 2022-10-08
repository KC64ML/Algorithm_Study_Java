package SWExpertAcademy;

import java.util.Scanner;

public class sw1979 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for(int i=0;i<num;i++){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[][] arr = new int[n+2][n+2];

            for(int j=0;j<n;j++){
                for(int q=0; q <n;q++){
                    arr[j][q] = sc.nextInt();
                }
            }


        }

    }
}
