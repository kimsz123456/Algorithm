import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {

			int N = Integer.parseInt(br.readLine());

			int[] start = new int[2];
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<2;j++) {
				start[j] = Integer.parseInt(st.nextToken());
			}
			
			int[][] mart = new int[N][2];
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<2;j++) {
					mart[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int[] end = new int[2];
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<2;j++) {
				end[j] = Integer.parseInt(st.nextToken());
			}
			
			Queue<int[]> queue = new ArrayDeque<>();
			boolean[] visited = new boolean[N];
			boolean result = false;
			queue.add(new int[] {start[0],start[1],20});
			while(!queue.isEmpty()) {
				int[] cur = queue.poll();
				int r = cur[0];
				int c = cur[1];
				int beer = cur[2];
				
				if((Math.abs(r-end[0])+Math.abs(c-end[1]))<=beer*50) {
					result = true;
				}
				for(int i=0;i<N;i++) {
					if(!visited[i] && (Math.abs(r-mart[i][0])+Math.abs(c-mart[i][1]))<=beer*50) {
						queue.add(new int[] {mart[i][0],mart[i][1],20});
						visited[i]=true;
					}
				}
			}
			if(result) {
				sb.append("happy\n");
			}
			else {
				sb.append("sad\n");
			}
		}
		System.out.println(sb);
	}
}
