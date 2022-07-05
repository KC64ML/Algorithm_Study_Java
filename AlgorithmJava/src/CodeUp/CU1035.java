package CodeUp;

import java.io.*;

public class CU1035 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int decimal = Integer.parseInt(br.readLine(),16);
        System.out.printf("%o",decimal);

        br.close();
    }
}
