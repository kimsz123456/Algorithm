import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        
        int[] server = new int[24];
        Arrays.fill(server,1);
        int answer = 0;
        int idx = 0;
        
        for(int player : players) {
            int max = server[idx]*m;
            if(max <= player){
                int expand = (player-max)/m +1;
                answer += expand;
                for(int i=idx;i<idx+k;i++){
                    if(i<24){
                        server[i]+=expand;
                    }
                }
            }
            
            idx++;
        }
        
        
        
        return answer;
    }
}