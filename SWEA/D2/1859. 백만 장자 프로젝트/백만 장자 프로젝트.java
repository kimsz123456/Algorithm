import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());	// 테스트 케이스
		
		for (int tc=1; tc<=T;tc++) {
			int N = Integer.parseInt(br.readLine());	// 자연수 N
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int[] arr = new int[N];
			for(int i=0;i<N;i++) {
				arr[i]=Integer.parseInt(st.nextToken());
			}
			
			// 뒤로가면서 max를 갱신하거나 max보다 작은값은 차익을 sum에 더함.
			int max=0;
			long sum=0;
			for(int i=N-1;i>=0;i--) {
				if(max<arr[i]) {
					max=arr[i];
				}
				else {
				sum += max - arr[i];
				}
			}
			System.out.println("#"+tc+" "+sum);
		}
	}
}		