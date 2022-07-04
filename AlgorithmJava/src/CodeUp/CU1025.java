package CodeUp;

import java.io.*;
import java.util.Collections;
import java.util.List;

public class CU1025 {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String s = br.readLine();
            String rs = "";

            for(int i=0;i<s.length();i++){
                rs += s.charAt(i);
                List list = Collections.nCopies(s.length()-i-1,"0");
                for (Object o : list) {
                    rs += o;
                }
                System.out.println("["+rs+"]");
                rs = "";
            }

            br.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
