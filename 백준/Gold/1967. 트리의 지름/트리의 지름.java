import java.util.*;
import java.io.*;

public class Main {
    
	static class Edge {
		int num;
		int w;
		
		Edge(int num, int w){
			this.num = num;
			this.w = w;
		}
	}
	
	static List<Edge>[] list;
	static boolean[] visited;
	static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
				
		int N = Integer.parseInt(br.readLine());
		
		list = new ArrayList[N+1];
		for(int i=1;i<=N;i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=1;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			list[start].add(new Edge(end,w));
			list[end].add(new Edge(start,w));
		}
		
		result = 0;
		for(int i=1;i<=N;i++) {
			visited = new boolean[N+1];
			visited[i] = true;
			DFS(i,0);
		}
		System.out.println(result);
	}
	
	static void DFS(int num,int sum) {
		for(Edge edge : list[num]) {
			if(!visited[edge.num]) {
				visited[edge.num]=true;
				DFS(edge.num,sum+edge.w);
			}
		}
		result = Math.max(result, sum);
	}
}