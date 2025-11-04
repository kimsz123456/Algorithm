import java.util.*;
import java.io.*;

public class Main {
    static int N,M;
    static char[][] field;
    static boolean[][] visited;
    static int ally=0,enemy=0;
    static int[] dr = {0,1,0,-1};
    static int[] dc = {1,0,-1,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        field = new char[M][N];
        visited = new boolean[M][N];

        for(int i=0;i<M;i++) {
            String str = br.readLine();
            for(int j=0;j<N;j++) {
                field[i][j] = str.charAt(j);
            }
        }
        bfs();
        System.out.print(ally+" "+enemy);
    }

    public static void bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        for(int i=0;i<M;i++) {
            for(int j=0;j<N;j++) {
                if(!visited[i][j]) {
                    char soldier = field[i][j];
                    int count = 1;
                    q.add(new int[] {i,j});
                    visited[i][j]=true;
                    while(!q.isEmpty()) {
                        int[] cur = q.poll();
                        int r = cur[0];
                        int c = cur[1];
                        for(int d=0;d<4;d++) {
                            int nr = r+dr[d];
                            int nc = c+dc[d];
                            if(boundary(nr,nc) && !visited[nr][nc] && field[nr][nc]==soldier) {
                                q.add(new int[] {nr,nc});
                                visited[nr][nc] = true;
                                count++;
                            }
                        }
                    }
                    if(soldier=='W') ally += count*count;
                    else enemy += count*count;
                }
            }
        }
    }

    public static boolean boundary(int r, int c) {
        return r>=0 && r<M && c>=0 && c<N;
    }

    public static int stoi(String str) {
        return Integer.parseInt(str);
    }
}