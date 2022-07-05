package CodeUp;


import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class CU1071 {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<String> list = new ArrayList<>();
        String s = br.readLine();
        String[] list_s = s.split(" ");


        for(int i =0 ;i<list_s.length;i++){
            if(list_s[i].equals("0")){
                break;
            }else{
                list.add(list_s[i]);
            }

        }

        for (String in_s : list) {
            System.out.println(in_s);
        }
    }
}

