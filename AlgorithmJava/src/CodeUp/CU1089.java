package CodeUp;

import java.io.*;

public class CU1089 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        Long[] arr = new Long[s.length];
        for (int i = 0; i < s.length; i++) {
            arr[i] = Long.parseLong(s[i]);
        }
        long answer = 0;
        for(int i =0;i<arr[2];i++){
            answer = arr[0] + (arr[1] * i);
        }

        System.out.println(answer);

        br.close();
    }
}

