import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine()); // 테스트케이스

		for (int tc = 1; tc <= T ; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			
			int[] room = new int[W];
			
			int count = 0;
			
			for (int i=0;i<N;i++) {	// N명의 사람에게 방을 배정한다.
				if(room[count]<H) {
					room[count]++;
				}
				else {
					count++;
					room[count]++;
				}
			}
			System.out.println((room[count]*100)+(count+1));
		}
	}
}