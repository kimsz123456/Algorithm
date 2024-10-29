import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	static int[][] house;
	static int[][] dir = {{1,0},{1,1},{0,1}};
	static int result = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		house = new int[N][N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				int num = Integer.parseInt(st.nextToken());
				house[i][j] = num;
			}
		}
		
		bfs();
		System.out.println(result);
	}
	
	static void bfs() {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {0,1,0});
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			int r = cur[0];
			int c = cur[1];
			int d = cur[2];
			
			if(r==N-1 && c==N-1) {
				result++;
			}
			switch(d) {
			// 오른쪽 우대각아래로 갈 수 있음
			case 0:
				// 오른쪽 갈수있는지
				if(c+1<N && house[r][c+1]==0) {
					queue.add(new int[] {r,c+1,0});
				}
				
				// 대각선
				if(r+1<N && c+1<N && house[r][c+1]+house[r+1][c]+house[r+1][c+1]==0) {
					queue.add(new int[] {r+1,c+1,1});
				}
				
				break;
			// 오른쪽 아래 우대각아래로 갈 수 있음
			case 1:
				
				// 오른쪽
				if(c+1<N && house[r][c+1]==0) {
					queue.add(new int[] {r,c+1,0});
				}
				
				// 대각선
				if(r+1<N && c+1<N && house[r][c+1]+house[r+1][c]+house[r+1][c+1]==0) {
					queue.add(new int[] {r+1,c+1,1});
				}
				
				// 아래
				if(r+1<N && house[r+1][c]==0) {
					queue.add(new int[] {r+1,c,2});
				}
				break;
			
			// 아래 우대각 아래로 갈 수 있음
			case 2:
				
				// 대각선
				if(r+1<N && c+1<N && house[r][c+1]+house[r+1][c]+house[r+1][c+1]==0) {
					queue.add(new int[] {r+1,c+1,1});
				}
				
				// 아래
				if(r+1<N && house[r+1][c]==0) {
					queue.add(new int[] {r+1,c,2});
				}
				break;
			}
		}
		
	}
}