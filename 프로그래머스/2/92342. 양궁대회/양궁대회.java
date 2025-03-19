import java.util.*;

class Solution {
    static int[] answer = new int[11];
    static int[] info;
    static int N;
    static int max = Integer.MIN_VALUE;
    static boolean flag;
    public int[] solution(int n, int[] info) {
        this.N = n;
        this.info=info;
        
        int sum = 0;
        for(int i=0;i<info.length;i++){
            if(info[i]!=0){
                sum += 10-i;
            }
        }
        dfs(0,0,sum,0,new int[11]);
        return flag?answer:new int[] {-1};
    }
    
    static void dfs(int depth,int count,int appeachSum,int lionSum,int[] scoreInfo) {
        if(count>N) {
            return;
        }
        if(depth>10) {
            return;
        }
        if(depth==10){
            if((appeachSum<lionSum) && max<=lionSum-appeachSum){
                flag=true;
                scoreInfo[depth] = (N-count);
                if(max<lionSum-appeachSum){
                    max = lionSum-appeachSum;
                    answer = scoreInfo.clone();
                }
                else{
                    for(int i=10;i>=0;i--){
                        if(answer[i]<scoreInfo[i]){
                           answer = scoreInfo.clone();
                           break;
                        }
                        else if(answer[i]>scoreInfo[i]){
                            break;
                        }
                    }
                }
            }
            return;
        }
        
        int appeach = info[depth];
        
        // 어피치 승리
        dfs(depth+1,count,appeachSum,lionSum,scoreInfo);

        // 라이언 승리
        scoreInfo[depth] = appeach+1;
        if(appeach!=0){
            dfs(depth+1,count+appeach+1,appeachSum-(10-depth),lionSum+(10-depth),scoreInfo);    
        }
        else{
            dfs(depth+1,count+appeach+1,appeachSum,lionSum+(10-depth),scoreInfo);
        }
        scoreInfo[depth] = 0;
    }
}