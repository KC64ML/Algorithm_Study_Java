package CodeUp;

import java.io.*;

public class CU1085 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        Long[] arr = new Long[s.length];
        for (int i = 0; i < s.length; i++) {
            arr[i] = Long.parseLong(s[i]);
        }

        double result = (double)(arr[0] * arr[1] * arr[2] * arr[3]) / 8388608;
        System.out.printf("%.1f MB",result);

        br.close();
    }
}
