package CodeUp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CU1011 {
    public static void main(String[] args) {

        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println(br.readLine());
            br.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
