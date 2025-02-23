import java.util.*;
import java.io.*;

class Solution {
    static int[] dr = {0,1,0,-1};
    static int[] dc = {1,0,-1,0};
    static int N,M;
    static boolean[][] visited;
    public int solution(int[][] land) {
        N = land.length;
        M = land[0].length;
        
        visited = new boolean[N][M];
        int[] count = new int[M];
        
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(land[i][j]==1 && !visited[i][j]){
                    boolean[] loc = new boolean[M];
                    Queue<int[]> queue = new ArrayDeque<>();
                    queue.add(new int[] {i,j});
                    visited[i][j]=true;
                    loc[j]=true;
                    int r = i;
                    int c = j;
                    int cnt = 0;
                    while(!queue.isEmpty()){
                        int[] cur = queue.poll();
                        r = cur[0];
                        c = cur[1];
                        cnt++;
                        for(int d=0;d<4;d++){
                            int nr = r+dr[d];
                            int nc = c+dc[d];
                            if(nr>=0 && nr<N && nc>=0 && nc<M && land[nr][nc]!=0 &&!visited[nr][nc]){
                                queue.add(new int[] {nr,nc});
                                visited[nr][nc]=true;
                                loc[nc]=true;
                            }
                        }
                    }
                    for(int num=0;num<M;num++){
                        if(loc[num]){
                            count[num]+=cnt;
                        }
                    }
                }
            }
        }
        int answer = 0;
        for(int i=0;i<M;i++){
            answer = Math.max(answer,count[i]);
        }
        
        return answer;
    }
}