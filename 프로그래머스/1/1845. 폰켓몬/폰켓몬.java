import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int N = nums.length;
        
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }
        
        int answer = Math.min(N/2,set.size());
        
        return answer;
    }
}