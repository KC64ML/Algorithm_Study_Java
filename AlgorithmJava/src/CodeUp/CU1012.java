package CodeUp;

import java.io.*;

public class CU1012 {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            float x = Float.parseFloat(br.readLine());
            System.out.format("%f",x);
            br.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
