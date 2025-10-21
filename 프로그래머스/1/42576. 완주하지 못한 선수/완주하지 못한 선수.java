import java.util.*;

class Solution {
    public String solution(String[] participants, String[] completion) {
        Map<String,Integer> map = new HashMap<>();
        for(String participant : participants) {
            map.put(participant,map.getOrDefault(participant,0)+1);
        }
        for(String participant : completion) {
            int count = map.get(participant);
            if(count==1) {
                map.remove(participant);
            }
            else{
                map.put(participant,count-1);
            }
        }
        String answer = "";
        for(String key : map.keySet()) {
            answer = key;
        }
        return answer;
    }
}