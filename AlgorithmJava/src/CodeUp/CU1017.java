package CodeUp;

import java.io.*;
import java.util.Collections;
import java.util.List;

public class CU1017 {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String s = br.readLine();
            List list = Collections.nCopies(3, s);
            for (Object o : list) {
                System.out.print(o + " ");
            }

            br.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
