package 포탑_부수기;

import java.util.Arrays;
import java.util.Comparator;

public class Test2 {
    private static class Node{
        public final int x;
        public final int y;
        public final int attack;

        Node(int y, int x, int attack) {
            this.x = x;
            this.y = y;
            this.attack = attack;
        }

        @Override
        public  String toString(){
            return this.y + " " + this.x + " " + this.attack;
        }
    }

    public static void main(String[] args) {
        int[][] come = {
                {0, 1, 8, 2},
                {3, 0, 7, 8},
                {1, 2, 0, 0},
                {9, 0, 3, 1},
                {9, 0, 3, 1},
                {9, 0, 3, 1}
        };

        int row = come.length;
        int col = come[0].length;
        Node[][] node = new Node[row][col];
        Node[] node_sorted = new Node[row * col];

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                node[i][j] = new Node(j, i, come[i][j]);
                node_sorted[(i * col) + j] = node[i][j];
            }
        }

        Arrays.sort(node_sorted, (n1, n2) ->{
            return n1.attack - n2.attack;
        });

        for(int i = 0; i < row * col; i++){
            System.out.println("y : " + node_sorted[i].y + " x : "+ node_sorted[i].x  + " : " + node_sorted[i].attack);
        }
    }
}

