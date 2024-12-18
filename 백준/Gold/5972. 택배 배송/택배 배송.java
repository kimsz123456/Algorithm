import java.io.*;
import java.util.*;

public class Main {
	static class Edge implements Comparable<Edge>{
		int v,w;
		
		Edge(int v, int w){
			this.v = v;
			this.w = w;
		}
		
		@Override
		public int compareTo(Edge other) {
			return this.w - other.w;
		}
	}
	
	static final int INF = Integer.MAX_VALUE;
	static int V,E;
	static int[] dist;
	static List<Edge>[] adjList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		adjList = new ArrayList[V+1];
		
		for(int i = 1 ; i<=V; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		dist = new int[V+1];
		Arrays.fill(dist, INF);
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			adjList[u].add(new Edge(v,w));
			adjList[v].add(new Edge(u,w));
		}
		
		dijkstra();
		System.out.println(dist[V]);
		
	}
	
	private static void dijkstra() {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[V+1];
		
		dist[1] = 0;
		
		pq.add(new Edge(1, 0));
		
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			if(visited[cur.v]) continue;
			visited[cur.v]= true;
			
			for(Edge edge : adjList[cur.v]) {
				if(!visited[edge.v] && dist[edge.v] > dist[cur.v]+edge.w  ) {
					dist[edge.v]= dist[cur.v]+ edge.w;
					pq.add(new Edge(edge.v, dist[edge.v]));
				}
			}
		}
	}
}