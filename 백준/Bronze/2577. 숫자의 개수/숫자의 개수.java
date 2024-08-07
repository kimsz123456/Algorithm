import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] arr = new int[3]; // A B C를 담을 배열
		int result = 1;	// A B C의 곱을 담을 변수
		for(int i=0;i<3;i++) {
			arr[i] = Integer.parseInt(br.readLine());
			result *= arr[i];
		}
		int[] count = new int[10]; // 카운팅배열
		String str = String.valueOf(result); // 문자열이 세기 편하니 변환
		
		for(int i=0; i<str.length();i++) {
			count[str.charAt(i)-'0']++;
		}
		for(int i=0; i<count.length;i++) {
			System.out.println(count[i]);
		}
		
	}
}