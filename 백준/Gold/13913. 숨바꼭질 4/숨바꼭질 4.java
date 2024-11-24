import java.io.*;
import java.util.*;

public class Main {
	
	static class Node {
		int loc,time;
		
		Node(int loc, int time){
			this.loc = loc;
			this.time = time;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		Queue<Node> queue = new ArrayDeque<>();
		int[] visited = new int[100001];
		int[] trace = new int[100001];
		Arrays.fill(trace, -1);
		Arrays.fill(visited, Integer.MAX_VALUE);
		queue.add(new Node (start,0));
		visited[start]=0;
		
		
		int result = Integer.MAX_VALUE;
		while(!queue.isEmpty()) {
			Node current = queue.poll();
			int loc = current.loc;
			int time = current.time;
			
			if (loc==end & time<=result) {
				result = time;
				break;
			}
			
			if(loc<end && loc*2< 100001 && visited[loc*2]>=time+1 ) {
				queue.add(new Node (loc*2,time+1));
				visited[loc*2]=time+1;
				trace[loc*2]=loc;
			}
			if(loc<end && loc<100000 && visited[loc+1]>=time+1) {
				queue.add(new Node (loc+1,time+1));
				visited[loc+1]=time+1;
				trace[loc+1]=loc;
			}
			if(loc>0 && visited[loc-1]>=time+1) {
				queue.add(new Node (loc-1,time+1));
				visited[loc-1]=time+1;
				trace[loc-1]=loc;
			}
		}
		System.out.println(result);
		
		Stack<Integer> stack = new Stack<>();
		int num = end;
		while(trace[num]!=-1){
			stack.add(trace[num]);
			num = trace[num];
		}
		while(!stack.isEmpty()) {
			sb.append(stack.pop()).append(" ");
		}
		sb.append(end);
		System.out.println(sb);
	}
}