import java.io.*;
import java.util.*;

public class Main {
	static class Point implements Comparable<Point> {
		int x,y;
		public Point(int x, int y) {
	        this.x = x;
	        this.y = y;
	    }
	    @Override
	    public int compareTo(Point o) {
	        if (this.x == o.x)
	            return this.y-o.y;
	        return this.x-o.x;
	    }
	}
	static class Line {
	    Point a, b;
	    public Line(Point p1, Point p2) {
	        a = p1.compareTo(p2)<=0?p1:p2;
	        b = p1.compareTo(p2)<=0?p2:p1;
	    }
	    public Line(int x1, int y1, int x2, int y2) {
	        this(new Point(x1, y1), new Point(x2, y2));
	    }
	    public boolean isIntersection(Line other) {
	        int res1 = CCW.getCCW(this.a, this.b, other.a);
	        int res2 = CCW.getCCW(this.a, this.b, other.b);
	        int res3 = CCW.getCCW(other.a, other.b, this.a);
	        int res4 = CCW.getCCW(other.a, other.b, this.b);

	        if (res1!=res2 && res3!=res4)
	            return true;

	        if (res1==0 && res2==0 && res3==0 && res4==0)
	            return this.a.compareTo(other.b)<=0 && other.a.compareTo(this.b)<=0;
	        return false;
	    }
	}
	
	static class CCW {
	    public static int getCCW(Point a, Point b, Point c) {
	        Point[] arr = {a,b,c,a};
	        long sum = 0;
	        for (int i = 0; i < 3; i++) {
	            sum += 1l*arr[i].x*arr[i+1].y-1l*arr[i+1].x*arr[i].y;
	        }
	        return sum>0?1:sum<0?-1:0;
	    }
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		Line line1 = new Line(stoi(st.nextToken()),stoi(st.nextToken()),stoi(st.nextToken()),stoi(st.nextToken()));
		st = new StringTokenizer(br.readLine());
		Line line2 = new Line(stoi(st.nextToken()),stoi(st.nextToken()),stoi(st.nextToken()),stoi(st.nextToken()));
		System.out.println(line1.isIntersection(line2)?1:0);
	}
	public static int stoi(String str) {
		return Integer.parseInt(str);
	}
}
