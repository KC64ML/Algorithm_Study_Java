package CodeUp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CU1083 {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for(int i = 1; i<= n;i++){
            if(i == 3 || i == 6 || i == 9){
                System.out.printf("X ");
            }else{
                System.out.printf("%d ",i);
            }

        }

        br.close();
    }
}

