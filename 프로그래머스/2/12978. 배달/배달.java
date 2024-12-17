import java.util.*;

class Solution {
    static int n;
    static int k;
    static List<int[]>[] adj;
    static int[] dist;
    static final int INF = Integer.MAX_VALUE;
    
    public int solution(int N, int[][] road, int K) {
        n = N;
        k = K;
        
        dist = new int[n+1];
		Arrays.fill(dist, INF);
        
        adj = new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            adj[i] = new ArrayList<>();
        }
        
        for(int i=0;i<road.length;i++){
            int[] cur = road[i];
            int start = cur[0];
            int end = cur[1];
            int weight = cur[2];
            adj[start].add(new int[] {end,weight});
            adj[end].add(new int[] {start,weight});
        }
        
        int answer = dijk();

        return answer;
    }
    
    static int dijk(){
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->{
            return Integer.compare(o1[1],o2[1]);
        });
        boolean[] visited = new boolean[n+1];
        
        pq.add(new int[] {1, 0});
        dist[1]=0;
        
        while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			
			if(visited[cur[0]]) continue;
			visited[cur[0]]= true;
			
			for(int[] edge : adj[cur[0]]) {
				if(!visited[edge[0]] && dist[edge[0]] > dist[cur[0]]+edge[1]  ) {
					dist[edge[0]]= dist[cur[0]]+ edge[1];
					pq.add(new int[] {edge[0], dist[edge[0]]});
				}
			}
		}
        
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] <= k) count++;
        }
        return count;
    }
}