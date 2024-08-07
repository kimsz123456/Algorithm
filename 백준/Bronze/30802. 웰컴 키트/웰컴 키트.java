import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[6];
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		for (int i=0;i<arr.length;i++) {
				arr[i]=Integer.parseInt(st1.nextToken());
		}
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st2.nextToken());
		int P = Integer.parseInt(st2.nextToken());
		
		int Tcnt = 0;
		int Pgroupedcnt = N/P;
		int Pcnt = N%P;
		for(int j=0;j<arr.length;j++) {
			Tcnt += Math.ceil((double) arr[j]/T);
		}
		System.out.println(Tcnt);
		System.out.print(Pgroupedcnt+" "+Pcnt);
	}
}
