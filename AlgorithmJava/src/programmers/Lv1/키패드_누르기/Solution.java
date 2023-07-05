package programmers.Lv1.키패드_누르기;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    // (2) 플레이어의 손 상태 나타내기
    private static class Hand {
        private final int baseX;
        public final String hand;
        public final float preference;
        private int x;
        private int y;

        public Hand(String hand, boolean isPreferred, int x){
            this.hand = hand;
            this.baseX = x;
            this.preference = isPreferred ? 0.5f : 0;
            this.x = x;
            this.y = 3;
        }

        public float distance(int x, int y) {
            if(x == baseX) return 0;
            int distance = Math.abs(x - this.x) + Math.abs(y - this.y);
            return distance - preference;
        }

        public void move(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    // (1) 키 패드 숫자 위치 찾기
    private int getX(int number) {
        if(number == 0) return 1;
        return (number - 1) % 3;
    }

    private int getY(int number) {
        if( number == 0) return 3;
        return (number - 1) / 3;
    }

    // (3) 키패드의 숫자 누르기
    private Hand press(int number, Hand right, Hand left) {
        int x = getX(number);
        int y = getY(number);

        float rDistance = right.distance(x, y);
        float lDistance = left.distance(x, y);

        Hand hand = right;
        if (lDistance < rDistance) {
            hand = left;
        }
        hand.move(x, y);
        return hand;
    }

    public String solution(int[] numbers, String hand) {
        // (4) 입력 처리하기
        Hand right = new Hand("R", hand.equals("right"), 2);
        Hand left = new Hand("L", hand.equals("left"), 0);

        return Arrays.stream(numbers).mapToObj(p -> press(p, right, left).hand).collect(Collectors.joining());
    }
}
