package programmers.LV2.교점에_별_만들기;

import java.util.*;

public class Solution3 {

    private long minX, minY;
    private long maxX, maxY;

    private static class Star{
        long x;
        long y;
        Star(long x, long y){
            this.x = x;
            this.y = y;
        }
    }

    private long[] getMinimum(List<Star> list){
        long minX = Long.MAX_VALUE;
        long minY = Long.MAX_VALUE;

        for(Star s : list){
            if(minX > s.x) minX = s.x;
            if(minY > s.y) minY = s.y;
        }
        return new long[]{minX, minY};
    }

    private long[] getMaximum(List<Star> list){
        long maxX = Long.MIN_VALUE;
        long maxY = Long.MIN_VALUE;

        for(Star s : list){
            if(maxX < s.x) maxX = s.x;
            if(maxY < s.y) maxY = s.y;
        }
        return new long[]{maxX, maxY};
    }

    // (1) 교차점 구하기 (정수형으로)
    private Star calculate(int[] line1, int[] line2){
        long A = line1[0]; long B = line1[1]; long E = line1[2];
        long C = line2[0]; long D = line2[1]; long F = line2[2];

        double x = (double)(B * F - E * D) / (A * D - B * C);
        double y = (double)(E * C - A * F) / (A * D - B * C);

        if(x % 1 != 0 || y % 1 != 0) return null;

        return new Star((long)x, (long)y);
    }


    public List<String> solution(int[][] line) {

        List<Star> list = new ArrayList<>();

        // 교점 추가
        for(int i = 0; i < line.length; i++){
            for(int j = 0; j < line.length; j++){
                if(i == j) continue;
                Star star = calculate(line[i], line[j]);

                if(star == null) continue;
                list.add(star);
            }
        }

        // 가장 큰 값, 작은 값 구함
        long[] smallXY = getMinimum(list);
        long[] bigXY = getMaximum(list);

        minX = smallXY[0];
        minY = smallXY[1];
        maxX = bigXY[0];
        maxY = bigXY[1];

        int row = (int)(maxY - minY) + 1;
        int col = (int)(maxX - minX) + 1;

        // 이차원 배열 생성
        char[][] picture = new char[row][col];

        for(char[] inPicture : picture){
            Arrays.fill(inPicture, '.');
        }

        // 이제 별 찍기
        for(Star star : list){
            // x = star.x - minX;
            // y = Math.abs(bigY - star.y)
            int nx = (int)(star.x - minX);
            int ny = (int)(Math.abs(maxY - star.y));

            picture[ny][nx] = '*';
        }

        List<String> answer = new ArrayList<>();

        for(char[] c : picture){
            answer.add(new String(c));
        }

        return answer;
    }
}
