import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        int N = topping.length;
        int[] left = new int[N+1];
        int[] right = new int[N+1];
        Set<Integer> leftSet = new HashSet<>();
        Set<Integer> rightSet = new HashSet<>();
        for(int i=0;i<N;i++) {
            leftSet.add(topping[i]);
            rightSet.add(topping[N-1-i]);
            left[i+1] = leftSet.size();
            right[N-1-i] = rightSet.size();
        }
        for(int i=1;i<N;i++) {
            if(left[i]==right[i]) answer++;
        }
        return answer;
    }
}