package programmers.LV2.옹알이;

public class Solution {

    static int firstAlpha(char firstChar){
        // 시작하는 해당 알파벳 1 2 3 4
        // 아닌 경우 -1
        if(firstChar == 'a') return 1;
        else if(firstChar == 'y') return 2;
        else if(firstChar == 'w') return 3;
        else if(firstChar == 'm') return 4;
        else return -1;
    }

    static int solution(String[] babbling) {
        int answer = 0;

        // 반복문을 통해 확인한다.

        for(String in_b : babbling){
            int curIdx = 0;
            String nextInB = in_b;
            boolean checkComb = false;
            String beforeAlpha = "";
            while(nextInB.length() > 0){
                // a, y, w, m으로 시작하는지 확인한다.
                int curFirstAlpha = firstAlpha(nextInB.charAt(0));
                int nextInBLength = nextInB.length();
                checkComb = false;

//                System.out.println("실행 : " + nextInB + " BEFORE Alpha : " + beforeAlpha);
                // a : 1, y : 2, w : 3, m : 4
                if(curFirstAlpha == 1 && nextInBLength >= 3 && !beforeAlpha.equals(nextInB)){

                    // System.out.println(nextInB);
                    if(nextInB.substring(0,3).equals("aya")){
                        // System.out.println("실행22");
                        beforeAlpha = "aya";
                        nextInB = nextInB.substring(3, nextInBLength);
                        checkComb = true;
                    }else {
                        nextInB = nextInB.substring(1, nextInBLength);
                        // System.out.println("실행실행");
                    }

                }else if(curFirstAlpha == 2 && nextInBLength >= 2 && !beforeAlpha.equals(nextInB)){


                    if(nextInB.substring(0,2).equals("ye")){
                        // System.out.println("before : " + beforeAlpha + " nextInB : " + nextInB.substring(0,2));
                        beforeAlpha = "ye";
                        nextInB = nextInB.substring(2, nextInBLength);
                        // System.out.println("nextInb : " + nextInB);
                        checkComb = true;
                    }else {
                        nextInB = nextInB.substring(1, nextInBLength);
                    }



                }else if(curFirstAlpha == 3 && nextInBLength >= 3 && !beforeAlpha.equals(nextInB)){

                    if(nextInB.substring(0,3).equals("woo")){
                        beforeAlpha = "woo";
                        nextInB = nextInB.substring(3, nextInBLength);
                        checkComb = true;
                    }else {
                        nextInB = nextInB.substring(1, nextInBLength);
                    }


                }else if(curFirstAlpha == 4 && nextInBLength >= 2 && !beforeAlpha.equals(nextInB)){

                    if(nextInB.substring(0,2).equals("ma")){
                        beforeAlpha = "ma";
                        nextInB = nextInB.substring(2, nextInBLength);
                        checkComb = true;
                    }else {
                        nextInB = nextInB.substring(1, nextInBLength);
                    }

                }else{
                    break;
                }
            }

            if(nextInB.length() == 0 && checkComb){
                // System.out.println("성공");
                answer += 1;
            }
        }

        return answer;
    }

    // ayayeye
    //ayayeayayeayaaya


}
