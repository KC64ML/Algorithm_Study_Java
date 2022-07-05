package CodeUp;

import java.io.*;
import java.util.*;

public class CU1072 {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int iNum = sc.nextInt();
        int arrNum[] = new int[iNum];

        for(int i=0;i<iNum;i++) {
            arrNum[i] = sc.nextInt();
            System.out.println(arrNum[i]);
        }
    }
}
