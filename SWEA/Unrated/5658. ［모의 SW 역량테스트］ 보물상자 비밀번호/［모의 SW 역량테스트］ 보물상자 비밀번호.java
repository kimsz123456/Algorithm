import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			String str = br.readLine();
			str += str;
			int num = N/4;
			String[] arr = new String[N];
			
			
			for(int i=0;i<N/4;i++) {
				for(int j=0;j<4;j++) {
					arr[i*4+j]=str.substring(i+j*num,i+num+j*num);
				}
			}
			long[] result = new long[N];
			
			for(int i=0;i<N;i++) {
				result[i]= hexadecimal(arr[i]);
			}
			Arrays.sort(result);
			
			int count=1;
			for(int i=result.length-1;i>0;i--) {
				if(count==K) {
					System.out.println("#"+tc+" "+result[i]);
					break;
				}
				if(result[i]!=result[i-1]) {
					count++;
				}
			}
			if(count==result.length) {
				System.out.println("#"+tc+" "+result[0]);
			}
		}	
	}
	
	static long hexadecimal(String str) {
		long answer = 0;
		for(int i=0;i<str.length();i++) {
			int a = str.charAt(str.length()-1-i)-'A';
			int b = str.charAt(str.length()-1-i)-'0';
			if(a>=0) {
				answer += Math.pow(16, i)*(a+10);
			}
			else {
				answer += Math.pow(16, i)*b;
			}
		}
		return answer;
	}
}