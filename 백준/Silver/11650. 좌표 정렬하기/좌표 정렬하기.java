import java.io.*;
import java.util.*;

public class Main {
	static class Point implements Comparable<Point>{
		int x, y;
		
		Point(int x,int y){
			this.x=x;
			this.y=y;
		}
		@Override
		public int compareTo(Point other) {
			if(this.x!=other.x) {
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
		
		List<Point> list = new ArrayList<>();
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			list.add(new Point(x,y));
		}
		Collections.sort(list);
		
		for(Point p : list) {
			sb.append(p.x).append(" ").append(p.y).append("\n");
		}
		System.out.println(sb);
	}
}