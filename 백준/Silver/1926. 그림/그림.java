import java.io.*;
import java.util.*;

public class Main {
	static int N,M;
	static boolean[][] visited;
	static int count=0;
	static int result=0;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[M][N];
		visited = new boolean[M][N];
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				int num = Integer.parseInt(st.nextToken());
				arr[i][j]=num;
				if(num==0) {
					visited[i][j]=true;
				}
			}
		}
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				if(!visited[i][j]) {
					bfs(i,j);
				}
			}
		}
		System.out.println(count);
		System.out.println(result);
		
	}
	public static void bfs(int r, int c) {
		Queue<int[]> queue = new ArrayDeque<>();
		int num=1;
		queue.offer(new int[] {r,c});
		visited[r][c]=true;
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			for(int i=0;i<dr.length;i++) {
				int nextr=current[0] +dr[i];
				int nextc=current[1] +dc[i];
				if(nextr<0||nextr>=M||nextc<0||nextc>=N||visited[nextr][nextc]) {
					continue;
				}
				queue.add(new int[] {nextr,nextc});
				visited[nextr][nextc]=true;
				num++;
			}
		}
		result = Math.max(result, num);
		count++;
	}
}