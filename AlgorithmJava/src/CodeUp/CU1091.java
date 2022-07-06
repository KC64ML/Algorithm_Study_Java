package CodeUp;

import java.io.*;

public class CU1091 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] a = br.readLine().split(" ");
        Long[] arr = new Long[a.length];

        for(int i =0;i< a.length;i++){
            arr[i] = Long.parseLong(a[i]);
        }
        long result = arr[0];
        for(int i=1;i<arr[3];i++){
            result = result * arr[1] + arr[2];
        }

        bw.write(String.valueOf(result));
        
        // 남아 있는 것을 모두 출력
        bw.flush();

        bw.close();
        br.close();
    }
}
