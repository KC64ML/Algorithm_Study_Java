package CodeUp;

import java.io.*;

public class CU1020 {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String s = br.readLine();
            String result = s.replace("-","");
            System.out.println(result);

            br.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
