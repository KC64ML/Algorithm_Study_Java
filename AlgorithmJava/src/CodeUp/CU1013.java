package CodeUp;

import java.io.*;

public class CU1013 {

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String s = br.readLine();
            String[] line_s = s.split(" ");
            for(int i = 0 ;i < line_s.length;i++){
                System.out.print(line_s[i] + " ");
            }

            br.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
