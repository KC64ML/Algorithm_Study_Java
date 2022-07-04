package CodeUp;

import java.io.*;
import java.util.Collections;

public class CU1014 {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String s = br.readLine();
            StringBuffer sb = new StringBuffer(s);
            s = sb.reverse().toString();
            String[] list_s = s.split(" ");
            for (String list_ : list_s) {
                System.out.print(list_ + " ");
            }
            br.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
