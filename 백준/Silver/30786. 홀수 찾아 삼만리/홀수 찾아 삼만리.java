import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = stoi(br.readLine());
		List<Integer> odd = new ArrayList<>();
		List<Integer> even = new ArrayList<>();
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
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

	public static int stoi(String str) {
		return Integer.parseInt(str);
	}
}
