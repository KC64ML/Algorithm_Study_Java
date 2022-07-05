package CodeUp;

import java.io.*;

public class CU1087 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        int sum = 0;
        for(int i=1; sum < (int)n;i++){
            sum += i;
        }
        System.out.println(sum);
        br.close();
    }
}

