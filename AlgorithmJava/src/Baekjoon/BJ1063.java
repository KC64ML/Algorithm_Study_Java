package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

enum Table {
    R(0, 1),
    L(0, -1),
    B(-1, 0),
    T(1, 0),
    RT(1, 1),
    LT(-1, 1),
    RB(-1, 1),
    LB(-1, -1);


    private int x;
    private int y;

    Table(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}

public class BJ1063 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        int n = Integer.parseInt(s[2]);
        int[][] arr = new int[9][9];
        int x1 = s[0].charAt(0) - 65 + 1;
        int y1 = 9 - (s[0].charAt(1) - '0');
        int x2 = s[1].charAt(0) - 65 + 1;
        int y2 = 9 - (s[1].charAt(1) - '0');
        arr[x1][y1] = 1;
        arr[x2][y2] = 2;
        for(int i = 0 ; i< n ; i++){
            String c = br.readLine();
            if(c.equals("R")){
                x1 += Table.R.getX();
                y1 += Table.R.getY();
            }else if(c.equals("L")){
                x1 += Table.L.getX();
                y1 += Table.L.getY();
            }else if(c.equals("B")){
                x1 += Table.B.getX();
                y1 += Table.B.getY();
            }else if(c.equals("T")){
                x1 += Table.T.getX();
                y1 += Table.T.getY();
            }
            else if(c.equals("RT")){
                x1 += Table.RT.getX();
                y1 += Table.RT.getY();
            }
            else if(c.equals("LT")){
                x1 += Table.LT.getX();
                y1 += Table.LT.getY();
            }
            else if(c.equals("RB")){
                x1 += Table.B.getX();
                y1 += Table.B.getY();
            }
            else if(c.equals("LB")){
                x1 += Table.B.getX();
                y1 += Table.B.getY();
            }

            arr[x1][y1] = 1;
        }

        System.out.println(arr);
        br.close();

    }
}
