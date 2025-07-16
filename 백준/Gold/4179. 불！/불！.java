import java.sql.Array;
import java.util.*;
import java.io.*;


public class Main {
    static int R,C;
    static char[][] map;
    static int[][] distMap;
    static int[] dr = {0,1,0,-1};
    static int[] dc = {1,0,-1,0};
    static int[] jLoc = new int[3];
    static int jMin = Integer.MAX_VALUE;
    static List<int[]> fireList = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st= new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        distMap = new int[R][C];
        for(int i=0;i<R;i++){
            Arrays.fill(distMap[i],Integer.MAX_VALUE);
        }
        String str;
        for(int i=0;i<R;i++){
            str = br.readLine();
            for(int j=0;j<C;j++){
                char next = str.charAt(j);
                map[i][j] = next;
                if(next=='J'){
                    jLoc[0]=i;
                    jLoc[1]=j;
                    jLoc[2]=0;
                }
                if(next=='F'){
                    fireList.add(new int[] {i,j});
                }
            }
        }
        fire();
        move();
        if(jMin==Integer.MAX_VALUE){
            sb.append("IMPOSSIBLE");
        }
        else {
            sb.append(jMin);
        }
        System.out.print(sb);
    }
    public static void fire() {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[R][C];

        if(!fireList.isEmpty()){
            for(int[] loc : fireList){
                q.add(new int[] {loc[0],loc[1],0});
                visited[loc[0]][loc[1]] = true;
                distMap[loc[0]][loc[1]] = 0;
            }
        }
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            int dist = cur[2];
            for(int d=0;d<4;d++){
                int nr = r+dr[d];
                int nc = c+dc[d];
                if(boundary(nr,nc) && !visited[nr][nc] && (map[nr][nc]=='.' || map[nr][nc]=='J')){
                    q.add(new int[] {nr,nc,dist+1});
                    visited[nr][nc]=true;
                    distMap[nr][nc] = Math.min(distMap[nr][nc],dist+1);
                }
            }
        }
    }

    public static void move() {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[R][C];

        q.add(jLoc);
        visited[jLoc[0]][jLoc[1]]=true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            int dist = cur[2];
            for(int d=0;d<4;d++){
                int nr = r+dr[d];
                int nc = c+dc[d];
                if (!boundary(nr, nc)) {
                    jMin = Math.min(jMin, dist + 1);
                    return;
                }
                if (!visited[nr][nc] && map[nr][nc] != '#' && distMap[nr][nc] > dist + 1) {
                    q.add(new int[]{nr, nc, dist + 1});
                    visited[nr][nc] = true;
                }
            }
        }
    }

    public static boolean boundary(int r,int c){
        return r>=0 && r<R && c>=0 && c<C;
    }

    public static void debug() {
        for(int i=0;i<R;i++) {
            System.out.println(Arrays.toString(distMap[i]));
        }
    }
}