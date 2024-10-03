import java.io.*;
import java.util.*;

public class Main {
	static class Line implements Comparable<Line>{
		int x,y;
		Line(int x, int y){
			this.x = x;
			this.y = y;
		}
		
		@Override
		public int compareTo(Line other) {
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
		
		PriorityQueue<Line> pq = new PriorityQueue<>();
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			
			pq.add(new Line(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
		
		int result = 0;
		
		Line current = pq.poll();
		
		while(!pq.isEmpty()) {
			Line next = pq.poll();
			if(current.y>=next.x) {
				current.y = Math.max(current.y, next.y);
			}
			else {
				result+= current.y - current.x;
				current = next;
			}
		}
		result+= current.y - current.x;
		System.out.println(result);
		
	}
}