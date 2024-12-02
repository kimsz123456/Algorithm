import java.io.*;
import java.util.*;

public class Main {
	static class Node implements Comparable<Node> {
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
	
	static int N,M,R;
	static int[] item;
	static ArrayList<ArrayList<Node>> adj;
	static int[] dist;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		item = new int[N+1];
		for(int i=1;i<=N;i++) {
			item[i] = Integer.parseInt(st.nextToken());
		}
		
		adj = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }
        
        for(int i=1;i<=R;i++) {
        	st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
 
            adj.get(start).add(new Node(end, weight));
            adj.get(end).add(new Node(start, weight));
        }
        
        dist = new int[N + 1];
 
        int ans = 0;
        for (int i = 1; i <= N; i++) {
            ans = Math.max(ans, dijk(i));
        }
        
        System.out.println(ans);
	}
	static int dijk(int start) {
		Arrays.fill(dist, Integer.MAX_VALUE);
		boolean[] check = new boolean[N+1];
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dist[start] = 0;
 
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int end = cur.end;
 
            if (!check[end]) {
                check[end] = true;
 
                for (Node node : adj.get(end)) {
                    if (!check[node.end] && dist[node.end] > dist[end] + node.w) {
                        dist[node.end] = dist[end] + node.w;
                        pq.add(new Node(node.end, dist[node.end]));
                    }
                }
            }
        }
        int result = 0;
        
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= M) {
                result += item[i];
            }
        }
 
        return result;
	}
}