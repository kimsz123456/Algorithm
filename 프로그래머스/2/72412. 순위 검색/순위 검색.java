import java.util.*;

class Solution {
    Map<String, List<Integer>> map = new HashMap<>();
    
    public int[] solution(String[] infos, String[] queries) {
        int[] answer = new int[queries.length];
        
        for(String info : infos) {
            String[] parts = info.split(" ");
            String[] conditions = {parts[0], parts[1], parts[2], parts[3]};
            int score = Integer.parseInt(parts[4]);
            
            for(int i = 0; i < 16; i++) {
                StringBuilder key = new StringBuilder();
                for(int j = 0; j < 4; j++) {
                    if((i & (1 << j)) != 0) {
                        key.append(conditions[j]);
                    } else {
                        key.append("-");
                    }
                }
                
                String keyStr = key.toString();
                map.putIfAbsent(keyStr, new ArrayList<>());
                map.get(keyStr).add(score);
            }
        }
        
        for(List<Integer> scores : map.values()) {
            Collections.sort(scores);
        }
        
        for(int i = 0; i < queries.length; i++) {
            String query = queries[i];
            String[] parts = query.split(" and | ");
            
            String key = parts[0] + parts[1] + parts[2] + parts[3];
            int targetScore = Integer.parseInt(parts[4]);
            
            if(map.containsKey(key)) {
                List<Integer> scores = map.get(key);
                answer[i] = scores.size() - lowerBound(scores, targetScore);
            } else {
                answer[i] = 0;
            }
        }
        
        return answer;
    }
    
    private int lowerBound(List<Integer> scores, int target) {
        int left = 0, right = scores.size();
        
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(scores.get(mid) >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
}