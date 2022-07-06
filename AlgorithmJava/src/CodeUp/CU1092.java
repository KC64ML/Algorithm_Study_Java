package CodeUp;

import java.io.*;

public class CU1092 {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        Long[] arr = new Long[s.length];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Long.parseLong(s[i]);
        }

        long d = 1;

        while(((d % arr[0] == 0) && (d % arr[1] == 0) && (d % arr[2] == 0)) != true){
            d += 1;
        }

        bw.write(String.valueOf(d));
        br.close();
        bw.close();
    }
}
