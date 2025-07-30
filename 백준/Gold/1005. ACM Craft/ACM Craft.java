import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int T = stoi(br.readLine());
        
        for(int tc=1;tc<=T;tc++) {
        	st = new StringTokenizer(br.readLine());
        	int N = stoi(st.nextToken());
        	int K = stoi(st.nextToken());
        	
        	st = new StringTokenizer(br.readLine());
        	int[] D = new int[N+1];
        	for(int i=1;i<=N;i++) {
        		D[i] = stoi(st.nextToken());
        	}
        	
        	List<Integer>[] tech = new ArrayList[N+1];
        	for(int i=1;i<=N;i++) {
        		tech[i] = new ArrayList<>();
        	}
        	
        	int[] degree = new int[N+1];
        	for(int i=0;i<K;i++) {
        		st = new StringTokenizer(br.readLine());
        		int X = stoi(st.nextToken());
        		int Y = stoi(st.nextToken());
        		tech[X].add(Y);
        		degree[Y]++;
        	}
        	
        	int W = stoi(br.readLine());
        	
        	Queue<Integer> q = new ArrayDeque<>();
        	int[] result = new int[N+1];
        	
        	for(int i=1;i<=N;i++) {
        		result[i] = D[i];
        		if(degree[i]==0) q.add(i);
        	}
        	
        	while(!q.isEmpty()) {
        		int cur = q.poll();
        		for(int next : tech[cur]) {
        			result[next] = Math.max(result[next],result[cur]+D[next]);
        			degree[next]--;
        			if(degree[next]==0) q.add(next);
        		}
        	}
        	System.out.println(result[W]);
        }
    }
    
    public static int stoi(String str) {
    	return Integer.parseInt(str);
    }
}