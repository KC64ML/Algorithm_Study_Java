import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        // (1) arrayA로 모두 검토
        int divdeA = 0;
        int divdeB = 0;
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        for(int div = arrayA[0]; div >= 2; div--){
            boolean check = true;
            for(int arrA : arrayA){
                if(arrA % div != 0){
                    check = false;
                    break;
                }
            }
            
            if(check){
                divdeA = div;
                break;
            }
        }
        
        for(int div = arrayB[0]; div >= 2; div--){
            boolean check = true;
            for(int arrB : arrayB){
                if(arrB % div != 0){
                    check = false;
                    break;
                }
            }
            
            if(check){
                divdeB = div;
                break;
            }
        }
        
        boolean check = true;
        for(int arrA : arrayA){
            if(divdeB == 0 || arrA % divdeB == 0){
                check = false;
                break;
            }
        }
        
        int answer = 0;
        if(check) answer = divdeB;
        
        check = true;
        for(int arrB : arrayB){
            if(divdeA == 0 || arrB % divdeA == 0){
                check = false;
                break;
            }
        }
        
        
        if(check) answer = Math.max(divdeA, divdeB);
        
        return answer;
        
    }
}