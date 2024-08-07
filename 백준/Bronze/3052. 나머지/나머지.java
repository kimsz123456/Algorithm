import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = 10;
		int[] arr = new int[43]; 	// 카운팅배열
		for (int tc=0;tc<T;tc++) {
			int a=Integer.parseInt(br.readLine());
			arr[a%42]++;
		}
		int count = 0;
		for (int i=0;i<43;i++) {
			if(arr[i]!=0) {
				count++;
			}
		}
		System.out.println(count);
	}
}