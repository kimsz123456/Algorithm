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
		int K = Integer.parseInt(st.nextToken());
		
		List<List<int[]>> adjList = new ArrayList<>(); 
		
		for(int i=0;i<=N;i++) {
			adjList.add(new ArrayList<>());
		}
		
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			
			int[] arr = new int[M];
			for(int j=0;j<M;j++) {
				int num = Integer.parseInt(st.nextToken());
				arr[j] = num;
			}
			for(int num: arr) {
				adjList.get(num).add(arr);
			}
		}
		Queue<int[]> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[N+1];
		int result = -1;

		queue.add(new int[] {1,1});
		visited[1]=true;
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			int num = now[0];
			int cnt = now[1];
			
			if(num==N) {
				result=cnt;
				break;
			}
			for(int[] tube : adjList.get(num)) {
				for(int next: tube) {
					if(!visited[next]) {
						queue.add(new int[] {next,cnt+1});
						visited[next]=true;
					}
				}
			}
		}
		System.out.println(result);
	}
}