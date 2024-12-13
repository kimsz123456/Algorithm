import java.util.*;
import java.io.*;

public class Main {
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	static int N,L,R;
	static boolean[][] visited;
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(start());
	}
	
	static int start() {
		int day = 0;
		
		while(open()) {
			day++;
		}
		
		return day;
	}
	
	static boolean open() {
		visited = new boolean[N][N];
		boolean result=false;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!visited[i][j] && bfs(i,j)) {
					result=true;
				}
			}
		}
		
		return result;
	}
	
	static boolean bfs(int i,int j) {
		boolean result = false;
		
		Queue<int[]> queue = new ArrayDeque<>();
		List<int[]> list = new ArrayList<>();
		
		queue.add(new int[] {i,j});
		list.add(new int[] {i,j});
		visited[i][j] = true;
		int sum = map[i][j];
		
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			int r = now[0];
			int c = now[1];
			for(int d=0;d<4;d++) {
				int nr = r+dr[d];
				int nc = c+dc[d];
				if(nr>=0 && nr< N && nc>=0 && nc<N && !visited[nr][nc]) {
					int gap = Math.abs(map[nr][nc]-map[r][c]);
					if(gap>=L && gap<=R) {
						queue.add(new int[] {nr,nc});
						list.add(new int[] {nr,nc});
						visited[nr][nc]=true;
						sum+=map[nr][nc];
						result = true;
					}
				}
			}
		}
		
		for(int[] arr : list) {
			map[arr[0]][arr[1]] = sum/list.size();
		}
		
		
		return result;
	}
}