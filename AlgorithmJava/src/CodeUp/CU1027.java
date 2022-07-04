package CodeUp;

import java.io.*;

public class CU1027 {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String s = br.readLine();
            String[] result = s.split("\\.");

            String com = "";

            for (int i = result.length - 1; i >0 ; i--){
                com += result[i] + "-";
            }
            com += result[0];
            System.out.println(com);
            br.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
