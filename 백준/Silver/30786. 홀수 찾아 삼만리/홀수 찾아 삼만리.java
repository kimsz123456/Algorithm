import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		
		int N = nextInt();
		List<Integer> odd = new ArrayList<>();
		List<Integer> even = new ArrayList<>();
		
		for(int i=1;i<=N;i++) {
			int x = nextInt();
			int y = nextInt();
			if((x+y)%2==0) even.add(i); 
			else odd.add(i);
		}
		
		if (odd.isEmpty() || even.isEmpty()) {
            System.out.println("NO");
        }
		else {
            System.out.println("YES");
            for (int idx : odd) {
            	sb.append(idx).append(" ");
            }
            
            for (int idx : even) {
            	sb.append(idx).append(" ");
            }
            
            System.out.print(sb);
        }
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
