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
		
		int start = Integer.parseInt(br.readLine());
		
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
		}
		
		dijkstra(start);
		
		for(int i=1;i<=V;i++) {
			if(dist[i]==INF) {
				System.out.println("INF");
			}
			else {
				System.out.println(dist[i]);
			}
		}
	}
	
	private static void dijkstra(int start) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[V+1]; //방문처리
		
		dist[start] = 0; //시작 노드까지의 거리는 0으로 초기화
		
		pq.add(new Edge(start, 0));
		
		while(!pq.isEmpty()) {
			Edge curr = pq.poll();
			
			if(visited[curr.v]) continue; //이미 방문했다면 비용을 알고 있다는 뜻
			visited[curr.v]= true; //선택
			
			for(Edge edge : adjList[curr.v]) {
				if(!visited[edge.v] && dist[edge.v] > dist[curr.v]+edge.w  ) {
					dist[edge.v]= dist[curr.v]+ edge.w;
					pq.add(new Edge(edge.v, dist[edge.v]));
				}
			}
		}
	}
}
