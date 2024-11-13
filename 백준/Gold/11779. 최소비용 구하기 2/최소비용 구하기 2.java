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
	
	static int N,M,cnt;
	static int[] dist;
	static int[] route;
	static final int INF = 123456789;
	static List<Node>[] list;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		dist = new int[N+1];
		route = new int[N+1];
		
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
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		dijk(start,end);
		sb.append(dist[end]).append("\n");
		
		ArrayList<Integer> routes = new ArrayList<>();
        int current = end;
        while(current != 0) {
            routes.add(current);
            current = route[current];
        }
        sb.append(routes.size()).append("\n");
        
        for(int i = routes.size() - 1; i >= 0; i--) {
            sb.append(routes.get(i)).append(" ");
        }
        System.out.println(sb);
	}
	
	static void dijk(int start,int end) {
		Arrays.fill(dist, INF);
		boolean[] visited = new boolean[N+1];
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start,0));
		dist[start]=0;
		route[start]=0;
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			int now = cur.end;
			if(!visited[now]) {
				for (Node node : list[now]) {
                    if (!visited[node.end] && dist[node.end] > dist[now] + node.w) {
                        dist[node.end] = dist[now] + node.w;
                        pq.add(new Node(node.end, dist[node.end]));
                        route[node.end] = cur.end;
                    }
                }
				visited[now]=true;
			}
		}
	}
}