import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int N = stoi(st.nextToken());
        int M = stoi(st.nextToken());
        
        int[] degree = new int[N+1];
        ArrayList<Integer>[] list = new ArrayList[N+1];
        for(int i=1;i<=N;i++) {
        	list[i] = new ArrayList<>();
        }
        
        for(int i=0;i<M;i++) {
        	 st = new StringTokenizer(br.readLine());
        	 int num = stoi(st.nextToken());
        	 if(num==0) continue;
        	 int singer = stoi(st.nextToken());
        	 for(int j=1;j<num;j++) {
        		 int next = stoi(st.nextToken());
        		 list[singer].add(next);
        		 degree[next]++;
        		 singer = next;
        	 }
        }
        Queue<Integer> q = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();
        for(int i=1;i<=N;i++) {
        	if(degree[i]==0) q.add(i);
        }
        
        while(!q.isEmpty()) {
        	int cur = q.poll();
        	result.add(cur);
        	for(int num : list[cur]) {
        		degree[num]--;
        		if(degree[num]==0) q.add(num);
        	}
        }
        if (result.size() != N) {
            sb.append("0");
        }
        else {
        	for(int num : result) {
        		sb.append(num).append("\n");
        	}
        }
        
        System.out.print(sb);
    }
    
    public static int stoi(String str) {
    	return Integer.parseInt(str);
    }
}