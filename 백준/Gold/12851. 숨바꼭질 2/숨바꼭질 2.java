import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		Queue<int[]> queue = new ArrayDeque<>();
		int[] visited = new int[100001];
		Arrays.fill(visited, Integer.MAX_VALUE);
		queue.add(new int[] {start,0});
		visited[start]=0;
		
		int result = Integer.MAX_VALUE;
		int count = 0;
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			int loc = current[0];
			int time = current[1];
			
			if (loc==end & time<=result) {
				count++;
				result = time;
			}
			if(loc<end && loc*2< 100001 && visited[loc*2]>=time+1 ) {
				queue.add(new int[] {loc*2,time+1});
				visited[loc*2]=time+1;
			}
			if(loc<end && loc<100000 && visited[loc+1]>=time+1) {
				queue.add(new int[] {loc+1,time+1});
				visited[loc+1]=time+1;
			}
			if(loc>0 && visited[loc-1]>=time+1) {
				queue.add(new int[] {loc-1,time+1});
				visited[loc-1]=time+1;
			}
		}
		System.out.println(result);
		System.out.println(count);
	}
}