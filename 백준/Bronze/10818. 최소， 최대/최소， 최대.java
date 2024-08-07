import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine()); // 테스트케이스
		
		int max=-1000000;
		int min=1000000;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<T;i++) {
			int a= Integer.parseInt(st.nextToken());
			if(max<a) {
				max = a;
			}
			if(min>a) {
				min =a ;
			}
		}
		System.out.println(min+" "+max);
	}
}