package CodeUp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CU1081 {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String[] list_s = s.split(" ");

        for(int i = 1; i<= Integer.parseInt(list_s[0]);i++){
            for(int j = 1; j<= Integer.parseInt(list_s[1]);j++){
                System.out.println(i + " "+ j);
            }
        }

        br.close();
    }
}

