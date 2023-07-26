package programmers.Lv1.키패드_누르기;

import java.util.*;
import java.util.stream.Collectors;

public class Solution2{

    private static class Hand {
        private final int baseX;
        private final String hand;
        private final float preference;
        private int x;
        private int y;

        public Hand(String hand, boolean isPreference, int x){
            this.hand = hand;
            this.baseX = x;
            this.preference = isPreference ? 0.5f : 0;
            this.x = x;
            this.y = 3;
        }

        public float distance(int x, int y){
            if(x == baseX) return 0;
            int distance = Math.abs(this.x - x) + Math.abs(this.y - y);
            return distance - this.preference;
        }

        public void move(int x, int y){
            this.x = x;
            this.y = y;
        }
    }


    private int getX(int number){
        if(number == 0) return 1;
        return (number - 1) % 3;
    }

    private int getY(int number){
        if(number == 0) return 3;
        return (number - 1) / 3;
    }

    private Hand pass(int number, Hand right, Hand left){
        int x = getX(number);
        int y = getY(number);

        float lDistance = left.distance(x, y);
        float rDistance = right.distance(x, y);

        Hand hand = right;
        if(lDistance < rDistance) hand = left;
        hand.move(x, y);
        return hand;
    }

    public String solution(int[] numbers, String hand) {
        Hand right = new Hand("R", hand.equals("right"), 2);
        Hand left = new Hand("L", hand.equals("left"), 0);
        return Arrays.stream(numbers).mapToObj(p -> pass(p, right, left).hand).collect(Collectors.joining());
    }
}
