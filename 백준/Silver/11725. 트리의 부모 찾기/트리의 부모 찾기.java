import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        
        int[] p = new int[N+1];
        
        List<Integer>[] adj = new ArrayList[N+1];
        
        for(int i=1;i<=N;i++) {
        	adj[i] = new ArrayList<>();
        }
        
        boolean[] visited = new boolean[N+1];
        
        for(int i=1;i<N;i++) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	adj[a].add(b);
        	adj[b].add(a);
        }
        
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        visited[1]=true;
        
        while(!queue.isEmpty()) {
        	int cur = queue.poll();
        	for (int next : adj[cur]){
        		if(visited[next]) {
        			continue;
        		}
        		queue.add(next);
        		visited[next]=true;
        		p[next]=cur;
        	}
        }
        for(int i=2;i<=N;i++) {
        	sb.append(p[i]).append("\n");
        }
        System.out.println(sb);
    }
}