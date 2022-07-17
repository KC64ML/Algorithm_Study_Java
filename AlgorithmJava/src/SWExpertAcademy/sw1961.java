package SWExpertAcademy;

import java.io.*;
import java.util.*;


public class sw1961 {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i< t ; i++){
            int n = Integer.parseInt(br.readLine());
            char[][] arr = new char[n + 1][n + 1];

            for (int row = 0; row < n; row++) {
                final StringTokenizer st = new StringTokenizer(br.readLine());
                for (int col = 0; col < n; col++) {
                    arr[row][col] = st.nextToken().charAt(0);
                }
            }

            // 90도
            ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>(3);
            ArrayList<String> in_list = new ArrayList<>();
            for(int col = 0; col < n; col++){
                String s = "";
                for (int row = n - 1; row >= 0; row--) {
                    s += arr[row][col];
                }
                in_list.add(s);
            }

            list.add(in_list);

            in_list = new ArrayList<>();

            for (int row = n - 1; row >= 0; row--) {
                String s = "";
                for (int col = n - 1; col >= 0; col--) {
                    s += arr[row][col];
                }
                in_list.add(s);
            }
            list.add(in_list);

            in_list = new ArrayList<>();

            for (int col = n - 1; col >= 0; col--) {
                String s = "";
                for (int row = 0; row < n; row++) {
                    s += arr[row][col];
                }
                in_list.add(s);
            }
            list.add(in_list);

            System.out.printf("#%d\n",i+1);
            for (int x = 0; x < list.get(0).size(); x++) {
                for (int y = 0; y < list.size(); y++) {
                    System.out.printf("%s ",list.get(y).get(x));
                }
                System.out.println();
            }
        }


        br.close();
    }
}
