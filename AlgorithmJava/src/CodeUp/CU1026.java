package CodeUp;

import java.io.*;

public class CU1026 {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String time = br.readLine();
            String[] rs = time.split(":");
            System.out.println(Integer.parseInt(rs[1]));
            br.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
