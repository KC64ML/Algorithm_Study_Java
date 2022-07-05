package CodeUp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CU1082 {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine(), 16);

        for(int i = 1; i<= 15;i++){
            System.out.printf("%X*%X=%X\n",n,i,n*i);

        }

        br.close();
    }
}

