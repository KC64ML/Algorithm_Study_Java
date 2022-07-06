package CodeUp;

import java.io.*;

public class CU1093 {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String start = br.readLine();
        String[] list = br.readLine().split(" ");

        long[] a = new long[24];
        int[] arr = new int[list.length];
        for(int i=0;i< list.length;i++){
            arr[i] = Integer.parseInt(list[i]);
        }

        for (int i = 0; i < Integer.parseInt(start); i++) {
            a[arr[i]] += 1;
        }
        for (int i = 1; i < 24; i++) {
            bw.write(String.valueOf(a[i] + " "));
        }

        br.close();
        bw.close();
    }
}
