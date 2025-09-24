import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		Task[] task = new Task[N];
		int end = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			task[i] = new Task(d, w);
			end = Math.max(end, d);
		}
		Arrays.sort(task);
		int[] days = new int[end + 1];
		int start = 1;
		for (int i = 0; i < N; i++) {
			int deadLine = start + task[i].d;
			if (days[deadLine - 1] == 0) {
				days[deadLine - 1] = task[i].w;
			} else {
				for (int j = deadLine - 1; j > 0; j--) {
					if (days[j] == 0) {
						days[j] = task[i].w;
						break;
					}
				}
			}
		}
		int sum = 0;
		for (int i = 1; i <= end; i++) {
			sum += days[i];
		}
		System.out.println(sum);
	}

	public static class Task implements Comparable<Task> {
		int d;
		int w;

		public Task(int d, int w) {
			this.d = d;
			this.w = w;
		}

		@Override
		public int compareTo(Task o1) {
			return o1.w - this.w;
		}
	}
}