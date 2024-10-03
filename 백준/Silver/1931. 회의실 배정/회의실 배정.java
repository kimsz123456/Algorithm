import java.io.*;
import java.util.*;

public class Main {
	static class Meeting implements Comparable<Meeting>{
		int x,y;
		Meeting(int x, int y){
			this.x = x;
			this.y = y;
		}
		
		@Override
		public int compareTo(Meeting other) {
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
		
		PriorityQueue<Meeting> pq = new PriorityQueue<>();
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			
			pq.add(new Meeting(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
		
		PriorityQueue<Integer> reservation = new PriorityQueue<>();
		
		int size=0;
		while(!pq.isEmpty()) {
			Meeting next = pq.poll();
			if(!reservation.isEmpty()) {
				int end = reservation.peek();
				if(end <= next.x) {
					reservation.poll();
					size++;
					reservation.add(next.y);
				}
				else {
					if(end > next.y) {
						reservation.poll();
						reservation.add(next.y);
					}
				}
			}
			else {
				reservation.add(next.y);
			}
		}
		while(!reservation.isEmpty()) {
			reservation.poll();
			size++;
		}
		System.out.println(size);
	}
}