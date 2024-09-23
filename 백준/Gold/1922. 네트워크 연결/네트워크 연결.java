import java.io.*;
import java.util.*;

public class Main {
	static class Edge implements Comparable<Edge>{
		int A,B,W;
		
		Edge(int A, int B, int W){
			this.A = A;
			this.B = B;
			this.W = W;
		}
		
		@Override
		public int compareTo(Edge other) {
			return this.W - other.W;
		}
	}
	
	static final int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int V = Integer.parseInt(br.readLine());
		int E = Integer.parseInt(br.readLine());
		
		List<Edge>[] adjList = new ArrayList[V+1];
		
		for(int i = 1 ; i<=V; i++) {
			adjList[i] = new ArrayList<>();
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			
			adjList[A].add(new Edge(A,B,W));
			adjList[B].add(new Edge(B,A,W));
		}
		
		boolean[] visited = new boolean[V+1];
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		visited[1] = true;

		int ans = 0;
		int pick = 1;
		
		pq.addAll(adjList[1]);
		
		while(pick != V) {
			Edge e = pq.poll();
			if(visited[e.B]) continue;
			
			ans += e.W;
			visited[e.B] = true;
			pick++;
			
			pq.addAll(adjList[e.B]);
		}
		
		
		System.out.println(ans);

	}
}
