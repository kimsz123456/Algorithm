import java.io.*;
import java.util.*;

public class Main {
	static class Node implements Comparable<Node> {
		int loc,cnt;
		Node(int loc,int cnt){
			this.loc=loc;
			this.cnt=cnt;
		}
		@Override
		public int compareTo(Node other) {
			return Integer.compare(this.cnt, other.cnt);
		}
	}
	static int[] game,count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		game = new int[101];
		for(int i=1;i<=100;i++) {
			game[i]=i;
		}
		
		for(int i=0;i<N+M;i++) {
			st = new StringTokenizer(br.readLine());
			game[Integer.parseInt(st.nextToken())]=Integer.parseInt(st.nextToken());
		}
		System.out.println(bfs(1));
	}
	
	static int bfs(int start) {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		boolean[] visited = new boolean[101];
		queue.add(new Node(start,0));
		visited[start]=true;
		int result=0;
		while(!queue.isEmpty()) {
			Node current = queue.poll();
			for(int dice = 1;dice<=6;dice++) {
				if (current.loc==100) {
					result = current.cnt;
					break;
				}
				int next = current.loc+dice;
				int nextcnt = current.cnt+1;
				if(next<=100 && !visited[next]) {
					queue.add(new Node(game[next],nextcnt));
					visited[next]=true;
				}
			}
		}
		return result;
	}
}