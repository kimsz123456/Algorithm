import java.sql.Array;
import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] map;
    static int[] dr = {0,1,0,-1};
    static int[] dc = {1,0,-1,0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = stoi(br.readLine());

        map = new int[N][N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = stoi(st.nextToken());
            }
        }

        numbering();

        int answer = makeBridge();
        System.out.print(answer);

    }
    public static int makeBridge() {
        int length = Integer.MAX_VALUE;

        int island;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(map[i][j]==0) continue;
                island = map[i][j];
                Queue<int[]> q = new ArrayDeque<>();
                boolean[][] visited = new boolean[N][N];
                q.add(new int[] {i,j,0});
                visited[i][j] = true;
                while(!q.isEmpty()){
                    int[] cur = q.poll();
                    int r = cur[0];
                    int c = cur[1];
                    int dist = cur[2];

                    for(int d=0;d<4;d++){
                        int nr = r+dr[d];
                        int nc = c+dc[d];
                        if(boundary(nr,nc) && !visited[nr][nc] && map[nr][nc]!=island) {
                            if(map[nr][nc]==0) {
                                q.add(new int[] {nr,nc,dist+1});
                                visited[nr][nc]=true;
                            }
                            else {
                                length = Math.min(length,dist);
                            }
                        }
                    }
                }
            }
        }
        return length;
    }

    public static void numbering() {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][N];
        int idx = 2;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(visited[i][j] || map[i][j]==0) continue;
                q.add(new int[] {i,j});
                visited[i][j]=true;
                while(!q.isEmpty()) {
                    int[] cur = q.poll();
                    int r = cur[0];
                    int c = cur[1];
                    if(map[r][c]!=0){
                        map[r][c]=idx;
                    }
                    for(int d=0;d<4;d++){
                        int nr = r+dr[d];
                        int nc = c+dc[d];
                        if(boundary(nr,nc) && !visited[nr][nc] && map[nr][nc]!=0) {
                            visited[nr][nc]=true;
                            q.add(new int[] {nr,nc});
                        }
                    }
                }
                idx++;
            }
        }
    }

    public static boolean boundary(int r, int c){
        return r>=0 && r<N && c>= 0 && c<N;
    }

    public static int stoi(String str){
        return Integer.parseInt(str);
    }

    public static void debug() {
        for(int i=0;i<N;i++){
            System.out.println(Arrays.toString(map[i]));
        }
    }
}