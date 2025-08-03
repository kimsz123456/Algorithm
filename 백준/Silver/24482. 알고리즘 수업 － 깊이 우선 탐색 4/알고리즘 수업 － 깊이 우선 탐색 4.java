import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static List<Integer>[] adj;
	static boolean[] visited;
	static int[] answer;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        N = stoi(st.nextToken());
        int M = stoi(st.nextToken());
        int R = stoi(st.nextToken());
        
        adj = new ArrayList[N+1];
        for(int i=1;i<=N;i++) {
        	adj[i] = new ArrayList<>();
        }
        visited = new boolean[N+1];
        
        for(int i=0;i<M;i++) {
        	st = new StringTokenizer(br.readLine());
        	int u = stoi(st.nextToken());
        	int v = stoi(st.nextToken());
        	adj[u].add(v);
        	adj[v].add(u);
        }
        
        for(int i=1;i<=N;i++) {
        	Collections.sort(adj[i],Collections.reverseOrder());
        }
        
        answer = new int[N+1];
        Arrays.fill(answer, -1);
        
        dfs(R,0);
        
        for(int i=1;i<=N;i++) {
        	sb.append(answer[i]).append("\n");
        }
        
        System.out.print(sb);
    }
    
    public static void dfs(int num,int depth) {
    	visited[num]=true;
    	answer[num]=depth;
    	for(int x:adj[num]) {
    		if(!visited[x]) dfs(x,depth+1);
    	}
    }
    
    public static int stoi(String str) {
    	return Integer.parseInt(str);
    }
}