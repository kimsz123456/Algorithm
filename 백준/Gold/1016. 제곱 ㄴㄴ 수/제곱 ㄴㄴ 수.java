import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long min = Long.parseLong(st.nextToken());
		long max = Long.parseLong(st.nextToken());
		
		long count = max-min+1;
		boolean[] check = new boolean[(int) count];
		
		for(long i=2; i*i<=max; i++) {
			long pow = i*i;
			long tmp = min/pow;
			if(min%pow != 0) {
				tmp += 1;
			}
			
			for(long j = tmp; j*pow<=max; j++) {
				int idx = (int)(j*pow-min);
				if(!check[idx]) {
					check[idx] = true;
					count--;
				}
			}
		}
		System.out.println(count);
	}
}