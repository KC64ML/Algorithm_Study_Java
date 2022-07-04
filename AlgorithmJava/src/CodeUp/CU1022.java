package CodeUp;

import java.io.*;

public class CU1022 {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String s = br.readLine();
            System.out.println(s);
            br.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
