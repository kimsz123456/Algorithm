import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			int N = Integer.parseInt(br.readLine());
			
			String result = "";
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				String alphabet = st.nextToken();
				int num = Integer.parseInt(st.nextToken());
				for(int j=0;j<num;j++) {
					result +=alphabet;
				}
			}
			System.out.println("#"+tc);
			for(int i=0;i<result.length();i++) {
				System.out.print(result.charAt(i));
				if(i%10==9) {
					System.out.println();
				}
			}
			System.out.println();
		}
		
	}
}
