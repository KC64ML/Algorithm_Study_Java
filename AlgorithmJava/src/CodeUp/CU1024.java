package CodeUp;

import java.io.*;

public class CU1024 {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String s = br.readLine();

            for(int i=0;i<s.length();i++){
                System.out.println("'"+ s.charAt(i) + "'");
            }

            br.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
