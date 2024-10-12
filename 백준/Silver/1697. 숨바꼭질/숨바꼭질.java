import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int max = 100001;
		boolean[] visited = new boolean[max];
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {N,0});
		visited[N]=true;
		int result = 0;
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			int now = current[0];
			int count = current[1];
			
			if(now==K) {
				result=count;
				break;
			}
			if(now*2<max && !visited[now*2]) {
				queue.add(new int[] {now*2,count+1});
				visited[now*2]=true;
			}
			if(now+1<max && !visited[now+1]) {
				queue.add(new int[] {now+1,count+1});
				visited[now+1]=true;
			}
			if(now-1>=0 && !visited[now-1]) {
				queue.add(new int[] {now-1,count+1});
				visited[now-1]=true;
			}
		}
		System.out.println(result);
	}
}