class Solution {
    static int N,M,answer;
    static boolean[][] red,blue;
    static int[][] map;
    static int[] dr = {0,1,0,-1};
    static int[] dc = {1,0,-1,0};
    public int solution(int[][] maze) {
        N = maze.length;
        M = maze[0].length;
        map = maze;
        red = new boolean[N][M];
        blue = new boolean[N][M];
        int[] b = new int[2];
        int[] r = new int[2];
        
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(maze[i][j]==1){
                    r = new int[] {i,j};
                    red[i][j]=true;
                }
                else if(maze[i][j]==2){
                    b = new int[] {i,j};
                    blue[i][j]=true;
                }
            }
        }
        
        answer = 0;
        move(0,b,r);
        return answer;
    }
    
    static void move(int n, int[] b, int[] r){
        if(map[b[0]][b[1]]==4 && map[r[0]][r[1]]==3){
            answer = answer==0? n : Math.min(answer,n);
        }
        
        int br,bc,rr,rc;
        if(map[b[0]][b[1]]==4){
            for(int d=0;d<4;d++){
                rr = r[0]+dr[d];
                rc = r[1]+dc[d];
                if(rr>=0 && rr<N && rc>=0 && rc<M && map[rr][rc]!=5 && !red[rr][rc]){
                    if(!(b[0]==rr && b[1]==rc)){
                        red[rr][rc]=true;
                        move(n+1,b,new int[] {rr,rc});
                        red[rr][rc]=false;
                    }
                }
            }
        }
        else if(map[r[0]][r[1]]==3){
            for(int d=0;d<4;d++){
                br = b[0]+dr[d];
                bc = b[1]+dc[d];
                if(br>=0 && br<N && bc>=0 && bc<M && map[br][bc]!=5 && !blue[br][bc]){
                    if(!(r[0]==br && r[1]==bc)){
                        blue[br][bc]=true;
                        move(n+1,new int[] {br,bc},r);
                        blue[br][bc]=false;
                    }
                }
            }
        }
        else{
            for(int d=0;d<4;d++){
                rr = r[0]+dr[d];
                rc = r[1]+dc[d];
                if(rr>=0 && rr<N && rc>=0 && rc<M && map[rr][rc]!=5 && !red[rr][rc]){
                    for(int dd=0;dd<4;dd++){
                        br = b[0]+dr[dd];
                        bc = b[1]+dc[dd];
                        if(br>=0 && br<N && bc>=0 && bc<M && map[br][bc]!=5 && !blue[br][bc]){
                            if(!(br==r[0]&&bc==r[1]&&rr==b[0]&&rc==b[1]) && !(br==rr && bc==rc)){
                                blue[br][bc]=true;
                                red[rr][rc]=true;
                                move(n+1,new int[] {br,bc}, new int[] {rr,rc});
                                red[rr][rc]=false;
                                blue[br][bc]=false;
                            }
                        }
                    }
                }
            }
        }
    }
}