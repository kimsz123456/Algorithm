import java.util.*;

class Solution {
    
    static int N;
    static int[][] Q;
    static int[] ANS;
    static List<Integer> list = new ArrayList<>();
    static int answer = 0;
    
    public int solution(int n, int[][] q, int[] ans) {
        this.N = n;
        this.ANS = ans;
        this.Q = q;
        
        dfs(1,0);
        
        return answer;
    }
    
    void dfs(int idx, int cnt) {
        if(cnt==5){
            if(check()) answer++;
            return;
        }
        for(int i=idx;i<=N;i++){
            list.add(i);
            dfs(i+1,cnt+1);
            list.remove(list.size()-1);
        }
    }
    
    boolean check(){
        for(int i=0;i<Q.length;i++){
            int cnt=0;
            for(int j=0;j<Q[i].length;j++){
                for(int num: list){
                    if (num == Q[i][j]) cnt++;
                }
            }
            if(ANS[i]!=cnt) return false;
        }
        return true;
    }
}