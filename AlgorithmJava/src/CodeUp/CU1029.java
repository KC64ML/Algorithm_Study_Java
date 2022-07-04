package CodeUp;

import java.io.*;

public class CU1029 {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String s = br.readLine();
            System.out.format("%.11lf",Float.parseFloat(s));

            br.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
