package CodeUp;

import java.io.*;

public class CU1088 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        int sum = 0;
        for(int i=1; i <= (int)n;i++){
            if(i % 3 == 0){
                continue;
            }else{
                System.out.printf("%d ",i);
            }
        }
        br.close();
    }
}

