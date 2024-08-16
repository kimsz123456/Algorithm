import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine()); // 테스트케이스 개수

		for (int tc = 1; tc <= T; tc++) {
			String str = br.readLine();
			for(int i=1;i<str.length()/2;i++) {
				if(str.substring(0,i).equals(str.substring(i,2*i))) {
					System.out.println("#"+tc+" "+i);
					break;
				}
			}
		}
	}
}
