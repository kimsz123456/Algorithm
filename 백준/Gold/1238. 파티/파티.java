import java.util.*;
import java.io.*;

public class Main {
	
	static class Node implements Comparable<Node>{
		int end;
		int w;
		Node(int end, int w){
			this.end = end;
			this.w = w;
		}
		@Override
		public int compareTo(Node other) {
			return Integer.compare(this.w, other.w);
		}
	}
	
	static int N,M,X;
	static int[] dist;
	static final int INF = 123456789;
	static List<Node>[] list;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		dist = new int[N+1];
		
		list = new ArrayList[N+1];
		for(int i=1;i<=N;i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[start].add(new Node(end,w));
		}
		int result = 0;
		for(int i=1;i<=N;i++) {
			result = Math.max(result, dijk(i,X)+dijk(X,i));
		}
		System.out.println(result);
	}
	
	static int dijk(int start,int end) {
		Arrays.fill(dist, INF);
		boolean[] visited = new boolean[N+1];
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start,0));
		dist[start]=0;
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			int now = cur.end;
			if(!visited[now]) {
				for (Node node : list[now]) {
                    if (!visited[node.end] && dist[node.end] > dist[now] + node.w) {
                        dist[node.end] = dist[now] + node.w;
                        pq.add(new Node(node.end, dist[node.end]));
                    }
                }
				visited[now]=true;
			}
		}
		return dist[end];
	}
}