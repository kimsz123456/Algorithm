import java.util.*;

class Solution {
    static int[] dr = {0,1,0,-1};
    static int[] dc = {1,0,-1,0};
    
    public int[] solution(String[][] places) {
        
        int[] answer = new int[5];
        
        char[][] room;
        for(int i=0;i<5;i++){
            room = new char[5][5];
            for(int j=0;j<5;j++){
                room[j] = places[i][j].toCharArray();
            }
            answer[i] = bfs(room);
        }
        
        return answer;
    }
    
    public int bfs(char[][] map){
        boolean flag = true;
        
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[5][5];
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                if(map[i][j]=='P'){
                    q.add(new int[] {i,j,0});
                    visited = new boolean[5][5];
                    visited[i][j]=true;
                    while(!q.isEmpty()){
                        int[] cur = q.poll();
                        int r = cur[0];
                        int c = cur[1];
                        int dist = cur[2];
                        if(dist>0 && dist<=2 && map[r][c]=='P'){
                            flag=false;
                            break;
                        }
                        if(dist>2) continue;
                        
                        for(int d=0;d<4;d++){
                            int nr = r+dr[d];
                            int nc = c+dc[d];
                            if(nr>=0 && nr<5 && nc>=0 && nc<5 && !visited[nr][nc] && map[nr][nc]!='X'){
                                q.add(new int[] {nr,nc,dist+1});
                                visited[nr][nc]=true;
                            }
                        }
                    }
                }
            }
        }
        return flag?1:0;
    }
}