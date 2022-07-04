package CodeUp;

import java.io.*;

public class CU1019 {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String s = br.readLine();
            String[] rs = s.split(".");
            for (String r : rs) {
                System.out.println("r = " + r);
            }
//            System.out.println("list_s = " + rs[0]);
//            System.out.format("%d.%02d.%02d",list_s[0],list_s[1],list_s[2]);

            br.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
