package CodeUp;

import java.io.*;
import java.util.Arrays;

public class CU1019 {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String s = br.readLine();
            String[] rs = s.split("\\.");
            int[] arr = Arrays.stream(rs).mapToInt(Integer::parseInt).toArray();
            System.out.format("%04d.%02d.%02d",arr[0],arr[1],arr[2]);

            br.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
