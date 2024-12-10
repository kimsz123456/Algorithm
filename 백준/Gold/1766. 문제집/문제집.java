import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<Integer>[] adj = new ArrayList[N+1];
		for(int i=1;i<=N;i++) {
			adj[i] = new ArrayList<>();
		}
		int[] indegree = new int[N+1];
		boolean[] solved = new boolean[N+1];
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			adj[A].add(B);
			indegree[B]++;
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(int i=1;i<=N;i++) {
			if(indegree[i]==0) {
				pq.add(i);
			}
		}
		
		while(!pq.isEmpty()) {
			int num = pq.poll();
			solved[num]=true;
			sb.append(num).append(" ");
			for(int next: adj[num]) {
				indegree[next]--;
				if(indegree[next]==0) {
					pq.add(next);
				}
			}
		}
		System.out.println(sb);
	}
}
