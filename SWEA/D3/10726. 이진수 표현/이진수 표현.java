import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			if (Math.pow(2,N)-1 == M%Math.pow(2,N)) {
				System.out.println("#"+tc+" "+"ON");
			}
			else {
				System.out.println("#"+tc+" "+"OFF");
			}
		}
	}
}
