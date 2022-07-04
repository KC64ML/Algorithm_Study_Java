package CodeUp;

import java.io.*;

public class CU1015 {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String s = br.readLine();
            float f = Float.parseFloat(s);
            System.out.format("%.2f",f);

            br.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
