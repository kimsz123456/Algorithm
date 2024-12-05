import java.io.*;
import java.util.*;

public class Main {
	static class Node implements Comparable<Node> {
		int value;
		int index;
		Node(int value, int index) {
			this.value = value;
			this.index = index;
		}
		@Override
		public int compareTo(Node other) {
			if(this.value==other.value) {
				return Integer.compare(this.index, other.index);
			}
			return Integer.compare(other.value,this.value);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		PriorityQueue<Node> seqA = new PriorityQueue<>();

		PriorityQueue<Node> seqB = new PriorityQueue<>();

		int N = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			int value = Integer.parseInt(st.nextToken());
			seqA.add(new Node(value, i));
		}

		int M = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < M; i++) {
			int value = Integer.parseInt(st.nextToken());
			seqB.add(new Node(value, i));
		}

		int prevA = -1;
		int prevB = -1;

		List<Integer> result = new ArrayList<>();

		while (!seqB.isEmpty() && !seqA.isEmpty()) {
			
			boolean flag = false;
			
			if(seqA.peek().index < prevA) {
				flag = true;
				seqA.poll();
			} 
			
			if(seqB.peek().index < prevB) {
				flag = true;
				seqB.poll();
			}
			
			if(flag) {
				continue;
			}

			if (seqA.peek().value == seqB.peek().value) {
				prevA = seqA.peek().index;
				prevB = seqB.peek().index;
				result.add(seqA.peek().value);
				seqA.poll();
				seqB.poll();
			} else if (seqA.peek().value > seqB.peek().value) {
				seqA.poll();
			} else {
				seqB.poll();
			}
		}
		
		sb.append(result.size()).append("\n");
		
		for(int num : result) {
			sb.append(num).append(" ");
		}
		System.out.println(sb);
	}
}