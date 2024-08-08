import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());	// 자연수 A을 입력받는다.
		int B = Integer.parseInt(st.nextToken());	// 자연수 B를 입력받는다.
		
		int GCD = 1;
		int LCM = A*B;
		int i=2;
		while(i<=A || i<=B) {
			if(A%i==0 && B%i==0) {
				A /= i;
				B /= i;
				GCD *=i;
				i=2;
			}
			else {
				i++;
			}
		}
		LCM /= GCD;
		System.out.println(GCD);
		System.out.println(LCM);
	}
}