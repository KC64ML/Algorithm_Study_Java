package CodeUp;

import java.io.*;

public class CU1018 {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String s = br.readLine();
            String[] list_s = s.split(":");
            System.out.println(list_s[0] + ":" + list_s[1]);


            br.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
