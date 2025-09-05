import java.io.*;
import java.util.*;

public class Main {
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = stoi(st.nextToken());
		int M = stoi(st.nextToken());
		int K = stoi(st.nextToken());
		
		char[][] map = new char[N][M];
		
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			map[i] = str.toCharArray();
		}
		
		st = new StringTokenizer(br.readLine());
		int sx,sy,tx,ty;
		sx = stoi(st.nextToken())-1;
		sy = stoi(st.nextToken())-1;
		tx = stoi(st.nextToken())-1;
		ty = stoi(st.nextToken())-1;
		
		Queue<int[]> q = new ArrayDeque<>();
		int[][] visited = new int[N][M];
		
		q.add(new int[] {sx,sy,1});
		visited[sx][sy]=1;
		
		int result=-1;
		q: while(!q.isEmpty()) {
			int[] cur = q.poll();
			int r = cur[0];
			int c = cur[1];
			int cnt = cur[2];
			
			for(int d=0;d<4;d++) {
				for(int k=1;k<=K;k++) {
					int nr = r+dr[d]*k;
					int nc = c+dc[d]*k;
					if(nr < 0 || nr >= N || nc<0 || nc>=M || map[nr][nc]=='#') break;
					if(nr==tx && nc==ty) {
						result = cnt;
						break q;
					}
					if(visited[nr][nc]==0) {
						visited[nr][nc]=cnt+1;
						q.add(new int[] {nr,nc,cnt+1});
					}
					else if(visited[nr][nc]==cnt+1) continue;
					else break;
				}
			}
		}
		System.out.print(result);
    }
	public static int stoi(String str) {
		return Integer.parseInt(str);
	}
}
