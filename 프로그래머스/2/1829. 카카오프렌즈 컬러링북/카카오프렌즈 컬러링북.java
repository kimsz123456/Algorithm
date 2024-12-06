import java.util.*;
import java.io.*;

class Solution {
    static boolean[][] visited;
    static int[] dr = {0,1,0,-1};
    static int[] dc = {1,0,-1,0};
    static int row;
    static int col;
    static int[][] picTemp;
    
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        
        row = m;
        col = n;
        
        visited = new boolean[row][col];
        picTemp = new int[row][col];
        
        for(int i=0;i<row;i++) {
            picTemp[i] = picture[i].clone();
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(picture[i][j]!=0 && !visited[i][j]){
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea,bfs(i,j,picture[i][j]));
                    numberOfArea++;
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    
    public static int bfs(int i,int j,int grade){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {i,j});
        int num = 0;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];
            for(int d=0;d<4;d++){
                int nr = r+dr[d];
                int nc = c+dc[d];
                if(nr>=0 && nr<row && nc>=0 && nc<col && !visited[nr][nc] && picTemp[nr][nc]==grade){
                    queue.add(new int[] {nr,nc});
                    visited[nr][nc]=true;
                    num++;
                }
            }
        }
        return num;
    }
}