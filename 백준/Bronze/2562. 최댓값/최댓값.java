import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 9;
		
		int max = 0; // max값을 담을 변수
		int a = 0; // 위치를 담을 변수
		for (int i = 0; i < T; i++) {
			int num = Integer.parseInt(br.readLine());
			max = Math.max(max,num);
			if (max==num) {
				a=i;
			}
		}
		System.out.println(max);
		System.out.println(a+1);
	}
}