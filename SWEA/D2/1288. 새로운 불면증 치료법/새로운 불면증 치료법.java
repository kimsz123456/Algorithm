import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
		
		for (int tc = 1; tc <= T; tc++) {
			int num = Integer.parseInt(br.readLine());
			int first = num;
			int[] arr = new int[10];
			for(int i=0;i<=9;i++) {
				arr[i]=1;
			}
			while(true) {
				String str = String.valueOf(num);
				for(int i=0;i<str.length();i++) {
					arr[str.charAt(i)-'0']=0;     
				}
				
				int sum = 0;
				for(int a=0;a<arr.length;a++) {
					sum+=arr[a];
				}
				
				if (sum==0) break;
				num = num+first;
			}
			System.out.println("#"+tc+" "+num);
		}
	}
}

