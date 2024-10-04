import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		
		int[] time = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			time[i]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(time);
		
		for(int i=0;i<N-1;i++) {
			time[i+1]+=time[i];
		}
		
		for(int i=0;i<N-1;i++) {
			time[i+1]+=time[i];
		}
		System.out.println(time[N-1]);
	}
}