package CodeUp;

import java.io.*;

public class CU1023 {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String s = br.readLine();
            String[] list_s = s.split("\\.");
            for (String list_ : list_s) {
                System.out.println(list_);
            }

            br.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
