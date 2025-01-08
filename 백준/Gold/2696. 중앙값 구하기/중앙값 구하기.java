import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			sb.append((N+1)/2);
			PriorityQueue<Integer> max = new PriorityQueue<>();
			PriorityQueue<Integer> min = new PriorityQueue<>(Collections.reverseOrder());

			for (int i = 0; i < N; i++) {
				if(i%10==0) {
					st = new StringTokenizer(br.readLine());
					if(i%20==0) {
						sb.append("\n");
					}
				}
				int num = Integer.parseInt(st.nextToken());

				if (max.isEmpty()) {
					max.add(num);
				} else {
					if (max.size() == min.size()) {
						if (min.peek() > num) {
							max.add(min.poll());
							min.add(num);
						} else {
							max.add(num);
						}
					} else {
						if (max.peek() > num) {
							min.add(num);
						} else {
							min.add(max.poll());
							max.add(num);
						}
					}
				}

				if (i % 2 == 0) {
					sb.append(max.peek()).append(" ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
