import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int a;
	static int sum=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 자연수 N을 입력받는다.
		int i = 0 ;
		boolean check=true;
		while(i<N) {
			if((creator(i)!=N)) {
				i++;
			}
			else{
				System.out.println(i);
				check=false;
				break;
			}
		}
		if(check) {
			System.out.println(0);
		}
	}
	public static int creator(int a) {
		int sum=0;
		sum += a;
		while(a>10) {
			sum += a%10;
			a /= 10;
		}
		return sum+a;
	}
}
