package CodeUp;


import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class CU1070 {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<String> list = new ArrayList<>();

        switch(br.readLine()){
            case "12":
            case "1":
            case "2":
                list.add("winter");
                break;
            case "3":
            case "4":
            case "5":
                list.add("spring");
                break;
            case "6":
            case "7":
            case "8":
                list.add("summer");
                break;
            case "9":
            case "10":
            case "11":
                list.add("fall");
                break;
        }

        for (String s : list) {
            System.out.println(s);
        }
    }
}

