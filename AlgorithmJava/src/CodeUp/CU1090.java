package CodeUp;

import java.io.*;

public class CU1090 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        Long[] arr = new Long[s.length];
        for (int i = 0; i < s.length; i++) {
            arr[i] = Long.parseLong(s[i]);
        }
        long answer = 0;

        answer = (long)(arr[0] * Math.pow(arr[1],arr[2] -1));

        System.out.println(answer);

        br.close();
    }
}

