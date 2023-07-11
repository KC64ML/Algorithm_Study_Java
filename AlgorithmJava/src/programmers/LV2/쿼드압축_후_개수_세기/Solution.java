package programmers.LV2.쿼드압축_후_개수_세기;

import java.sql.SQLOutput;

public class Solution {

    private static class Count {
        public final int zero;
        public final int one;

        public Count(int zero, int one) {
            this.zero = zero;
            this.one = one;
        }

        public Count add(Count other) {
            return new Count(zero + other.zero, one + other.one);
        }
    }

    private static Count count(int offsetX, int offsetY, int size, int[][] arr){
        int h = size / 2;
//        System.out.println("size 시작 : " + size + " offsetX : " +offsetX + " offsetY : " + offsetY);

        for(int x = offsetX; x < offsetX + size; x++){
            for(int y = offsetY; y < offsetY + size; y++){
//                System.out.println("size : " + size + " x : " + x + " y : " + y + " arr : " + arr[y][x] );
                if(arr[y][x] != arr[offsetY][offsetX]){
//                    System.out.println("offsetY, offsetX : " + offsetY + " " + offsetX + " "
//                            + arr[offsetY][offsetX] + " x : " +  x + " y : " + y + " arr : " + arr[y][x]);
                    return count(offsetX, offsetY, h, arr)
                            .add(count(offsetX + h, offsetY, h, arr))
                            .add(count(offsetX, offsetY + h, h, arr))
                            .add(count(offsetX + h, offsetY + h, h, arr));
                }
            }


        }

        if(arr[offsetY][offsetX] == 1){
            System.out.println("1Count 생성됨");
            return new Count(0, 1);
        }else{
            System.out.println("0Count 생성됨");
            return new Count(1, 0);
        }
    }

    public static int[] solution(int[][] arr) {
        Count count = count(0, 0, arr.length, arr);
        return new int[]{count.zero, count.one};
    }

    public static void main(String[] args) {
        int[][] example = {{1,1,0,1},{1,1,1,0},{1,0,0,1},{1,1,1,1}};

        solution(example);
    }
}