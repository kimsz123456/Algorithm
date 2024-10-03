import java.io.*;
import java.util.*;

public class Main {
	static class Lecture implements Comparable<Lecture>{
		int x,y;
		Lecture(int x, int y){
			this.x = x;
			this.y = y;
		}
		
		@Override
		public int compareTo(Lecture other) {
			if (this.x != other.x) {
				return Integer.compare(this.x, other.x);
			}
			else {
				return Integer.compare(this.y, other.y);
			}
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		
		Lecture[] lecture = new Lecture[N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			lecture[i] = new Lecture (Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		// 정렬
		Arrays.sort(lecture);
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		int endTime = 0;
		
		for(Lecture next : lecture) {
			endTime = next.y;
			if(!pq.isEmpty() && pq.peek() <=next.x) {
				pq.poll();
			}
			pq.add(endTime);
		}
		
		System.out.println(pq.size());
	}
}