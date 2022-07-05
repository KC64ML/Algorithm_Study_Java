package CodeUp;

import java.io.*;

public class CU1034 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int decimal = Integer.parseInt(br.readLine(), 8);
        System.out.format("%d",decimal);

        br.close();
    }
}
