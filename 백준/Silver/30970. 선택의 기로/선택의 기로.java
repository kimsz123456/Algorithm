import java.io.*;
import java.util.*;

public class Main {
	static class Obj {
		int quality;
		int price;
		Obj(int quality, int price){
			this.quality = quality;
			this.price = price;
		}
	}
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		
		int N = nextInt();
		PriorityQueue<Obj> pq1 = new PriorityQueue<>((o1,o2) -> {
			if(o1.quality!=o2.quality) {
				return -Integer.compare(o1.quality,o2.quality);
			}
			else {
				return Integer.compare(o1.price, o2.price);
			}
		});
		PriorityQueue<Obj> pq2 = new PriorityQueue<>((o1,o2) -> {
			if(o1.price!=o2.price) {
				return Integer.compare(o1.price,o2.price);
			}
			else {
				return -Integer.compare(o1.quality, o2.quality);
			}
		});
		for(int i=0;i<N;i++) {
			Obj obj = new Obj(nextInt(),nextInt());
			pq1.add(obj);
			pq2.add(obj);
		}
		for(int i=0;i<2;i++) {
			Obj cur = pq1.poll();
			sb.append(cur.quality).append(" ").append(cur.price).append(" ");
		}
		sb.append("\n");
		for(int i=0;i<2;i++) {
			Obj cur = pq2.poll();
			sb.append(cur.quality).append(" ").append(cur.price).append(" ");
		}
		System.out.print(sb);
	}
	static int nextInt() throws IOException {
        int c;
        while (!Character.isDigit(c = System.in.read()));
        int value = c & 15;
        while (Character.isDigit(c = System.in.read())) {
            value = value * 10 + (c & 15);
        }
        return value;
    }
}
