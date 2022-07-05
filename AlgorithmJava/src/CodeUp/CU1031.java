package CodeUp;

import java.io.*;

public class CU1031 {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.format("%o",Integer.parseInt(br.readLine()));

            br.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
