import java.util.*;
import java.io.*;

public class Main {
    static int n,m;
    static char[][] map;
    static int[] dr = {0,1,0,-1};
    static int[] dc = {1,0,-1,0};
    static boolean flag=false;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = stoi(st.nextToken());
        m = stoi(st.nextToken());

        int r = 0, c = 0;
        map = new char[n][m];
        for(int i=0;i<n;i++){
            String str = br.readLine();
            map[i] = str.toCharArray();
            for(int j=0;j<m;j++){
                if(map[i][j]=='2'){
                    r=i;
                    c=j;
                }
            }
        }
        bfs(r,c);

        if(flag) {
            sb.append("TAK").append("\n").append(min);
        }
        else {
            sb.append("NIE");
        }
        System.out.print(sb);
    }
    public static void bfs(int x, int y) {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];
        q.add(new int[] {x,y,0});
        visited[x][y]=true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            int l = cur[2];
            if(map[r][c]!='0' && map[r][c]!='2'){
                flag=true;
                min = Math.min(min,l);
            }
            for(int d=0;d<4;d++){
                int nr = r+dr[d];
                int nc = c+dc[d];
                if(boundary(nr,nc) && !visited[nr][nc] && map[nr][nc]!='1'){
                    q.add(new int[] {nr,nc,l+1});
                    visited[nr][nc]=true;
                }
            }
        }
    }
    public static boolean boundary(int r, int c){
        return r>=0 && r<n && c>=0 && c<m;
    }

    public static int stoi(String str) {
        return Integer.parseInt(str);
    }
}
