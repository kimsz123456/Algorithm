import java.io.*;
import java.util.*;

public class Main {
	static int R,C;
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		R = stoi(st.nextToken());
		C = stoi(st.nextToken());
		
		char[][] map = new char[R][C];
		int[][] timeMap = new int[R][C];
		boolean[][] visited = new boolean[R][C];
		for(int i=0;i<R;i++) {
			Arrays.fill(timeMap[i], Integer.MAX_VALUE);
		}
		
		Queue<int[]> q = new ArrayDeque<>();
		
		int startR=0,startC=0;
		for(int i=0;i<R;i++) {
			String str = br.readLine();
			for(int j=0;j<C;j++) {
				char c = str.charAt(j);
				map[i][j] = c;
				if(c=='S') {
					startR=i;
					startC=j;
				}
				else if(c=='*') {
					q.add(new int[] {i,j,0});
					timeMap[i][j]=0;
				}
			}
		}
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int time = cur[2];
			for(int d=0;d<4;d++) {
				int nr = cur[0]+dr[d];
				int nc = cur[1]+dc[d];
				if(boundary(nr,nc) && map[nr][nc]=='.' && timeMap[nr][nc]>time+1) {
					q.add(new int[] {nr,nc,time+1});
					timeMap[nr][nc]=time+1;
				}
			}
		}
		q.clear();
		
		int answer = Integer.MAX_VALUE;
		q.add(new int[] {startR,startC,0});
		visited[startR][startC]=true;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int time = cur[2];
			for(int d=0;d<4;d++) {
				int nr = cur[0]+dr[d];
				int nc = cur[1]+dc[d];
				if(boundary(nr,nc)) {
					if(map[nr][nc]=='.' && timeMap[nr][nc]>time+1 && !visited[nr][nc]) {
						q.add(new int[] {nr,nc,time+1});
						visited[nr][nc]=true;
					}
					if(map[nr][nc]=='D') {
						answer = Math.min(answer, time+1);
					}
				}
			}
		}
		System.out.println((answer==Integer.MAX_VALUE)?"KAKTUS":answer);
	}
	public static boolean boundary(int r,int c) {
		return r>=0 && r<R && c>=0 && c<C;
	}
	
	public static int stoi(String str) {
		return Integer.parseInt(str);
	}
}