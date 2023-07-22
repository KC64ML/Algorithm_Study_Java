package programmers.LV2.소수_찾기;

import java.util.*;
import java.util.stream.Collectors;

public class Solution4 {

    private boolean prime(int number){
        if(number <= 1) return false;
        for(int i = 2; i * i <= number; i++){
            if(number % i == 0) return false;
        }
        return true;
    }


    private void perm(int acc, List<Integer> list, Set<Integer> primes){
        if(prime(acc)) primes.add(acc);
        for(int i = 0; i < list.size(); i++){
            int nextAcc = acc * 10 + list.get(i);
            List<Integer> nextList = new ArrayList<>(list);
            nextList.remove(i);
            perm(nextAcc, nextList, primes);
        }
    }

    public int solution(String numbers) {
        List<Integer> list = numbers.chars().map((c) -> c - '0').boxed().collect(Collectors.toList());
        Set<Integer> primes = new HashSet<>();
        perm(0, list, primes);
        return primes.size();
    }
}