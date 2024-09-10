import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int E = Integer.parseInt(br.readLine());

		boolean[][] adjarr = new boolean[N+1][N+1]; 
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			adjarr[a][b]=true;
			adjarr[b][a]=true;
		}
		
		boolean[] visited = new boolean[N+1];
		
		Queue<Integer> queue = new ArrayDeque<>();
		
		queue.add(1);
		visited[1]=true;
		int count=0;
		while(!queue.isEmpty()) {
			int num = queue.poll();
			for(int i=1;i<=N;i++) {
				if(adjarr[num][i]&&!visited[i]) {
					queue.add(i);
					visited[i]=true;
					count++;
				}
			}
		}
		System.out.println(count);
	}

}
