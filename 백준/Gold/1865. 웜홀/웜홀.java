import java.io.*;
import java.util.*;

public class Main {
	static class Edge {
		int e,t;
		public Edge(int e,int t) {
			this.e = e;
			this.t = t;
		}
	}
	static final int INF = 987654321;
	static int N,M,W;
	static int[] dist;
	static List<Edge>[] adjList;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        for(int tc=1;tc<=T;tc++) {
        	st = new StringTokenizer(br.readLine());
        	N = Integer.parseInt(st.nextToken());
        	M = Integer.parseInt(st.nextToken());
        	W = Integer.parseInt(st.nextToken());
        	
        	dist = new int[N+1];
        	adjList = new ArrayList[N+1];
        	for(int i=0;i<=N;i++) {
        		adjList[i] = new ArrayList<>();
        	}
        	
        	for(int i=0;i<M;i++) {
        		st = new StringTokenizer(br.readLine());
        		int s = Integer.parseInt(st.nextToken());
        		int e = Integer.parseInt(st.nextToken());
        		int t = Integer.parseInt(st.nextToken());
        		adjList[s].add(new Edge(e,t));
        		adjList[e].add(new Edge(s,t));
        	}
        	
        	for(int i=0;i<W;i++) {
        		st = new StringTokenizer(br.readLine());
        		int s = Integer.parseInt(st.nextToken());
        		int e = Integer.parseInt(st.nextToken());
        		int t = Integer.parseInt(st.nextToken());
        		adjList[s].add(new Edge(e,-t));
        	}
        	
        	boolean result = false;
        	for (int i = 1; i <= N; i++) {
                if (bellmanFord(i)) {
                    result = true;
                    sb.append("YES\n");
                    break;
                }
            }
        	if (!result) {
                sb.append("NO\n");
            }
        }
        System.out.println(sb);
	}
    public static boolean bellmanFord(int start) {
        Arrays.fill(dist, INF);
        dist[start] = 0;
        boolean update = false;
        
        for (int i = 1; i < N; i++) {
            update = false;
            
            for (int j = 1; j <= N; j++) {
                for (Edge edge : adjList[j]) {
                    if (dist[j] != INF && dist[edge.e] > dist[j] + edge.t) {
                        dist[edge.e] = dist[j] + edge.t;
                        update = true;
                    }
                }
            }
            if (!update) {
                break;
            }
        }
        if (update) {
            for (int i = 1; i <= N; i++) {
                for (Edge edge : adjList[i]) {
                    if (dist[i] != INF && dist[edge.e] > dist[i] + edge.t) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
