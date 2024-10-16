import java.io.*;
import java.util.*;

public class Main {
	static char[] command = {'D','S','L','R'};

	static class Node implements Comparable<Node> {
		int num;
		int count;
		String command;

		Node(int num, int count, String command) {
			this.num = num;
			this.count = count;
			this.command = command;
		}

		@Override
		public int compareTo(Node other) {
			return Integer.compare(this.count, other.count);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());

			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			sb.append(bfs(A,B)).append("\n");
		}
		System.out.println(sb);
	}

	static String bfs(int A, int B) {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		int[] visited = new int[10001];
		Arrays.fill(visited, Integer.MAX_VALUE);
		queue.add(new Node(A, 0, ""));
		visited[A]=0;
		String result = "";
		while (!queue.isEmpty()) {
			Node current = queue.poll();
			int cnt = current.count+1;
			String com = current.command;
			int next = 0;
			String str = "";
			int length =0;
			if(current.num==B) {
				result = current.command;
				break;
			}
			for (int d = 0; d < 4; d++) {
				switch (d) {
				case 0:
					next = (current.num*2)%10000;
					break;
				case 1:
					next = (current.num+9999)%10000;
					break;
				case 2:
					next = (current.num % 1000) * 10 + current.num / 1000;
					break;
				case 3:
					next = (current.num % 10) * 1000 + current.num / 10;
					break;
				}
				if(visited[next]>cnt) {
					queue.add(new Node(next,cnt,com+command[d]));
					visited[next]=cnt;
				}
			}
		}
		return result;
	}
	
}