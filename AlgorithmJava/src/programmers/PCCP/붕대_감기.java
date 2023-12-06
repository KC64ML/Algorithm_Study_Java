package programmers.PCCP;

class 붕대_감기 {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int time = health;
        int beforeAttackTime = 0;

        for(int[] attack : attacks){
            int attackTime = attack[0];
            int damage = attack[1];

            // System.out.println(beforeAttackTime + " " + attackTime);
            time += ((attackTime - 1) - beforeAttackTime) / bandage[0] * bandage[2];
            time += ((attackTime - 1) - beforeAttackTime) * bandage[1];
            time = (time > health ? health : time);
            time -= damage;
            beforeAttackTime = attackTime;

            if(time <= 0) break;
            // System.out.println(attackTime + " 결과 : " + time);
        }

        return (time <= 0 ? -1 : time);
    }
}