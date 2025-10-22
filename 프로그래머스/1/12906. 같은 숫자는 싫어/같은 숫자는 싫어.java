import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        
        List<Integer> list = new ArrayList<>();
        
        int before = -1;
        for(int num : arr) {
            if(before==num) continue;
            list.add(num);
            before=num;
        }
        
        int[] answer = new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}