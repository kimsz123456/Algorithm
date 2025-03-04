import java.util.*;

class Solution {
    static int N,M;
    static char[][] map;
    static int[] dr = {0,1,0,-1};
    static int[] dc = {1,0,-1,0};
    public int solution(String[] storage, String[] requests) {
        N = storage.length+2;
        M = storage[0].length()+2;
        map = new char[N][M];
        for(int i=0;i<N;i++){
            Arrays.fill(map[i],'@');
        }
        for(int i=1;i<N-1;i++){
            for(int j=1;j<M-1;j++){
                map[i][j] = storage[i-1].charAt(j-1);
            }
        }
        
        for(String request : requests) {
            char c=request.charAt(0);
            List<int[]> removeList = new ArrayList<>();
            if(request.length()==2){
                for(int i=0;i<N;i++){
                    for(int j=0;j<M;j++){
                        if(map[i][j]==c){
                            map[i][j]='@';
                        }
                    }
                }
            }
            else{
                boolean[][] boundary = bfs();
                for(int i=1;i<N-1;i++){
                    for(int j=1;j<M-1;j++){
                        if(map[i][j]==c){
                            for(int d=0;d<4;d++){
                                int ni = i+dr[d];
                                int nj = j+dc[d];
                                if(boundary[ni][nj]){
                                    removeList.add(new int[] {i,j});
                                    break;
                                }
                            }
                        }
                    }
                }
                for(int[] loc : removeList){
                    map[loc[0]][loc[1]]='@';
                }
            }
            
        }
        
        int answer = 0;
        for(int i=1;i<N-1;i++){
            for(int j=1;j<M-1;j++){
                if(map[i][j]!='@'){
                    answer++;
                }
            }
        }
        
        
        return answer;
    }
    
    static boolean[][] bfs(){
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0,0});
        visited[0][0]=true;
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];
            for(int d=0;d<4;d++){
                int nr = r+dr[d];
                int nc = c+dc[d];
                if(nr>=0 && nr<N && nc>=0 && nc<M && !visited[nr][nc] && map[nr][nc]=='@'){
                    queue.add(new int[]{nr,nc});
                    visited[nr][nc]=true;
                }
            }
        }
        return visited;
    }
}