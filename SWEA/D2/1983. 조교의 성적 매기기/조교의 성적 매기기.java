import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
	static int[][] tree;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

		for (int tc = 1; tc <= T; tc++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 총 학생 수
			int K = Integer.parseInt(st.nextToken()); // 알고싶은 학생의 번호

			int[] arr = new int[N];
			int score = 0;
			for(int i=0;i<N;i++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				arr[i]+=Integer.parseInt(st2.nextToken())*35+Integer.parseInt(st2.nextToken())*45+Integer.parseInt(st2.nextToken())*20;
				
				if (i==K-1) {
					score = arr[i];
				}
			}
			Arrays.sort(arr);
			int num=0;
			for(int i=0;i<N;i++) {
				if(arr[i]==score) {
					num = i;
				}
			}
			switch(num/(N/10)) {
			case 0 : System.out.println("#"+tc+" D0");
			break;
			case 1 : System.out.println("#"+tc+" C-");
			break;
			case 2 : System.out.println("#"+tc+" C0");
			break;
			case 3 : System.out.println("#"+tc+" C+");
			break;
			case 4 : System.out.println("#"+tc+" B-");
			break;
			case 5 : System.out.println("#"+tc+" B0");
			break;
			case 6 : System.out.println("#"+tc+" B+");
			break;
			case 7 : System.out.println("#"+tc+" A-");
			break;
			case 8 : System.out.println("#"+tc+" A0");
			break;
			case 9 : System.out.println("#"+tc+" A+");
			break;
			}
		}
	}
}
