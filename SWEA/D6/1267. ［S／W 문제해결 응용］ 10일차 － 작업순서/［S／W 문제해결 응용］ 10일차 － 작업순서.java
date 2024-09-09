import java.io.*;
import java.util.*;

public class Solution {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = 10;
        
        for(int tc=1;tc<=T;tc++) {
        	st = new StringTokenizer(br.readLine());
        	int V = Integer.parseInt(st.nextToken());
        	int E = Integer.parseInt(st.nextToken());
        	
        	
        	// 인접행렬
        	int[][] adjarr = new int[V+1][V+1];
        	// 진입차수
        	int[] indegree = new int[V+1];
        	st = new StringTokenizer(br.readLine());
        	for(int i=0;i<E;i++) {
        		int in = Integer.parseInt(st.nextToken());
        		int out = Integer.parseInt(st.nextToken());
        		adjarr[in][out]=1;
        		indegree[out]++;
        	}
        	
        	Queue<Integer> queue = new LinkedList<>();
        	
        	for(int i=1;i<V+1;i++) {
        		if (indegree[i]==0) {
        			queue.add(i);
        		}
        	}
        	sb.append("#").append(tc).append(" ");
        	while(!queue.isEmpty()) {
        		int num = queue.poll();
        		sb.append(num).append(" ");
        		for(int i=0;i<V+1;i++) {
        			if(adjarr[num][i]==1) {
        				adjarr[num][i]=0;
        				indegree[i]--;
        				if(indegree[i]==0) {
        					queue.add(i);
        				}
        			}
        		}
        	}
        	sb.append("\n");
        }
        System.out.println(sb);
    }
    
}