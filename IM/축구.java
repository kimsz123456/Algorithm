import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class 축구 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

		for (int tc = 1; tc <= T; tc++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); // 가로크기
			int k = Integer.parseInt(st.nextToken()); // 시간 k
			int[][] arr = new int[4][n];
			
			for(int i=0; i<4;i++) {
				for(int j=0;j<n;j++) {
					for(int num=0;num<=k;num++) {
						if(num==0) {
							continue;
						}
						if ((i+j+1)%num==0) {
						arr[i][j] = (arr[i][j]+1)%2;
						}
						else if(i+j+1<num) {
							break;
						}
					}
				}
			}
			int count=0;
			for (int i=0;i<arr.length;i++) {
				for(int j=0;j<arr[i].length;j++) {
					if (arr[i][j]==1) count++;
				}
			}
			System.out.println("#"+tc+" "+count);
		}
	}
}