import java.io.*;
import java.util.*;

public class Main {
	static class Lecture implements Comparable<Lecture>{
		int n,x,y;
		Lecture(int n,int x, int y){
			this.n = n;
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
		
		PriorityQueue<Lecture> pq = new PriorityQueue<>();
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			
			pq.add(new Lecture(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
		
		PriorityQueue<Integer> reservation = new PriorityQueue<>();
		
		
		while(!pq.isEmpty()) {
			Lecture next = pq.poll();
			if(!reservation.isEmpty() && reservation.peek() <=next.x) {
				reservation.poll();
			}
			reservation.add(next.y);
		}
		System.out.println(reservation.size());
	}
}