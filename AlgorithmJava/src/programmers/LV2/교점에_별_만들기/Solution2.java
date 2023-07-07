package programmers.LV2.교점에_별_만들기;



import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import java.util.*;

class Solution2 {

    private static class Point {
        long x;
        long y;

        Point(long x, long y){
            this.x = x;
            this.y = y;
        }
    }

    private static Point intersection(int[] line1, int[] line2){
        long A = line1[0]; long B = line1[1]; long E = line1[2];
        long C = line2[0]; long D = line2[1]; long F = line2[2];

        double x = (double)(B * F - E * D) / (A * D - B * C);
        double y = (double)(E * C - A * F) / (A * D - B * C);

        if(x % 1 != 0 || y % 1 != 0) return null;


        return new Point((long)x, (long)y);
    }

    private static Point getMinimumPoint(List<Point> list){
        long minX = Long.MAX_VALUE;
        long minY = Long.MAX_VALUE;

        for(Point inList : list){
            if(minX > inList.x) minX = inList.x;
            if(minY > inList.y) minY = inList.y;
        }

        return new Point(minX, minY);
    }

    private static Point getMaximumPoint(List<Point> list) {
        long maxX = Long.MIN_VALUE;
        long maxY = Long.MIN_VALUE;

        for(Point inList : list) {
            if(maxX < inList.x) maxX = inList.x;
            if(maxY < inList.y) maxY = inList.y;
        }

        return new Point(maxX, maxY);
    }

    public static String[] solution(int[][] line) {
        List<Point> list = new ArrayList<>();

        for(int i = 0; i < line.length; i++){
            for(int j = 0; j < line.length; j++){
                Point p = intersection(line[i], line[j]);

                if(p != null) list.add(p);
            }
        }


        // min, max 구함
        Point minimumP = getMinimumPoint(list);
        Point maximumP = getMaximumPoint(list);


        // 배열
        int weight = (int)(maximumP.x - minimumP.x);
        int height = (int)(maximumP.y - minimumP.y);

        char[][] arr = new char[height + 1][weight + 1];

        for(char[] c : arr){
            Arrays.fill(c, '.');
        }

        for(Point p : list){
            int curX = (int)(p.x - minimumP.x);
            int curY = (int)(maximumP.y - p.y);

            arr[curY][curX] = '*';
        }

        String[] answer = new String[arr.length];
        for(int i = 0; i < arr.length; i++){
            answer[i] = new String(arr[i]);
        }

        return answer;
    }
}

