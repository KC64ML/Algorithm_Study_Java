package CodeUp;

import java.io.*;

public class CU1047 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int decimal = Integer.parseInt(br.readLine());
        System.out.println(decimal << 1);

        br.close();
    }
}
