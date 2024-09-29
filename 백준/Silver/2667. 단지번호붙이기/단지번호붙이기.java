import java.io.*;
import java.util.*;

public class Main {
	static int N,num,area;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	static int result = 0;
	static List<Integer> list;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		visited = new boolean[N][N];
		
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<N;j++) {
				int now = str.charAt(j)-'0';
				map[i][j] = now;
				if(now==0) {
					visited[i][j]=true;
				}
			}
		}
		num=0;
		list = new ArrayList<>();
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!visited[i][j]) {
					area=0;
					dfs(i,j);
					list.add(area);
					num++;
				}
			}
		}
		System.out.println(num);
		Collections.sort(list);
		for(int a : list) {
			System.out.println(a);
		}
	}
	
	static void dfs(int r,int c) {
		visited[r][c]=true;
		map[r][c]=num;
		area++;
		for(int d=0;d<4;d++) {
			int nextr = r+dr[d];
			int nextc = c+dc[d];
			if(nextr>=0 && nextr < N && nextc >=0 && nextc < N && !visited[nextr][nextc]) {
				dfs(nextr,nextc);
			}
		}
	}
}