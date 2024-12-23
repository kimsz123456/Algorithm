import java.util.*;
import java.io.*;

class Solution {
    public int solution(String[] strs, String t) {
        
        int[] dp= new int[t.length()+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        
        Set<String> set = new HashSet<>();
        for(String str:strs){
            set.add(str);
        }
        dp[0]=0;
        
        for(int i=0;i<=t.length();i++){
            if(dp[i]==Integer.MAX_VALUE) continue;
            for(int j=1;j<=5 && i+j<=t.length();j++){
                if(set.contains(t.substring(i,i+j))){
                    dp[i+j]=Math.min(dp[i]+1,dp[i+j]);
                }
            }
        }
        
        return (dp[t.length()]==Integer.MAX_VALUE?-1:dp[t.length()]);
    }
}