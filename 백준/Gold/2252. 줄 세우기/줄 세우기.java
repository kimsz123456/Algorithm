import java.io.*;
import java.util.*;

public class Main {
	static List<Integer>[] adj;
	static boolean[] visited;
	static Stack<Integer> stack;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		
		adj = new ArrayList[N+1];
		for(int i=1;i<=N;i++) {
			adj[i] = new ArrayList<>();
		}
		
		int[] indegree = new int[N+1];
		visited = new boolean[N+1];
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int in = Integer.parseInt(st.nextToken());
			int out = Integer.parseInt(st.nextToken());
			
			adj[in].add(out);
			indegree[out]++;
		}
		
		stack = new Stack<>();
		
		for(int i=1;i<=N;i++) {
			if(indegree[i]==0) {
				dfs(i);
			}
		}
		while(!stack.empty()) {
			sb.append(stack.pop()).append(" ");
		}
		System.out.println(sb);
	}
	
	static void dfs(int curr) {
		visited[curr] = true;
		for (int num : adj[curr]) {
			if (!visited[num]) {
				dfs(num);
			}
		}
		stack.push(curr);
	}
}
