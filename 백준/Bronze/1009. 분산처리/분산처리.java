import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			int remainder = a%10;
			int idx = 1;
			while(true) {
				remainder = remainder * a % 10;
				if(remainder == a%10) {
					break;
				}
				idx++;
			}
			int result = 1;
			for (int i = 0; i < (b % idx == 0 ? idx : b % idx); i++) {
			    result = (result * a) % 10;
			}
			System.out.println(result == 0 ? 10 : result);
		}
	}
}
