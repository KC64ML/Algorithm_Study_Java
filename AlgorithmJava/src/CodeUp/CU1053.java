package CodeUp;

import java.io.*;

public class CU1053 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        if(num == 1){
            System.out.println(0);
        }else{
            System.out.println(1);
        }

        br.close();
    }
}
