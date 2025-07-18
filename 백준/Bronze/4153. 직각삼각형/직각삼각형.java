import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arr = new int[3];
			for (int i=0; i<arr.length;i++) {
				arr[i]=Integer.parseInt(st.nextToken());
			}
			if(arr[0]==0 && arr[1]==0 && arr[2]==0) {
				break;
			}
			Arrays.sort(arr);
			if(arr[0]*arr[0]+arr[1]*arr[1]==arr[2]*arr[2]) {
				System.out.println("right");
			}
			else {
				System.out.println("wrong");
			}
		}
    }
}
