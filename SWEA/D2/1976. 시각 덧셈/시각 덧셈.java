import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

		for (int tc = 1; tc <= T; tc++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int hour1= Integer.parseInt(st.nextToken());
			int minute1 = Integer.parseInt(st.nextToken());
			
			int hour2 = Integer.parseInt(st.nextToken());
			int minute2= Integer.parseInt(st.nextToken());
			
			int minute = 0;
			int hour = 0;
			if(minute1+minute2>=60) {
				hour= ((hour1+hour2+1)%12==0)?12:(hour1+hour2+1)%12 ;
				minute = minute1+minute2-60;
			}
			else {
				hour= ((hour1+hour2)%12==0)?12:(hour1+hour2)%12 ;
				minute = minute1+minute2;
			}
			System.out.println("#"+tc+" "+hour+" "+minute);
		}
	}
}

