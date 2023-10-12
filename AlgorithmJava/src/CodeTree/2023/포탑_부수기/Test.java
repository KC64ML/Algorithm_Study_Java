package 포탑_부수기;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Test {
    private static class Node implements Comparable<Node>{
        public final int x;
        public final int y;
        public final int attack;

        Node(int x, int y, int attack){
            this.x = x;
            this.y = y;
            this.attack = attack;
        }

        @Override
        public int compareTo(Node n ){
            if(n.attack < this.attack) return 1; // -1 this.attack이 앞에 위치한다.
            else if(n.attack == this.attack) return 0;
            else return -1;  // 1 뒤에 위치한다.
        }
    }
    public static void main(String[] args) {
        int N = 5; // N을 원하는 행 수로 변경
        int M = 5; // M을 원하는 열 수로 변경

        int[][] come = {
                {0, 1, 8, 2},
                {3, 0, 7, 8},
                {1, 2, 0, 0},
                {9, 0, 3, 1}
        };

        ArrayList<Node> list = new ArrayList<>();
//        Node[][] node = new Node[4][4];

        for(int i = 0; i < 16; i++){
            list.add(new Node(i, i / 4, come[i / 4][i % 4]));
        }

        Collections.sort(list);


        for(int i = 0; i < 16; i++){
            System.out.println(list.get(i).x + " " + list.get(i).y + " " + list.get(i).attack);
        }

//        int[][] arr = new int[4][4];
//        arr[0][3] = 1;
//        arr[1][0] = 1;
//
//        int[][] arr2 = new int[4][4];
//        arr[0][0] = 30;
//        for(int i = 0; i < 4; i++){
//            arr2[i] = arr[i].clone();
//        }
//
//        arr2[0][0] = 100;
//        arr2[2][0] = 100;
//
//        for(int i = 0; i < 4; i++){
//            System.out.println(Arrays.toString(arr[i]));
//        }
//        for(int i = 0; i < 4; i++){
//            System.out.println(Arrays.toString(arr2[i]));
//        }

    }
}
