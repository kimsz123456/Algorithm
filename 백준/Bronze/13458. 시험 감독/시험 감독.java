import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] room = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			room[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		long answer = N;
		int num;
		for(int i=0;i<N;i++) {
			num = room[i]-B;
			answer += (num>0? num/C + (num%C==0?0:1) :0);
		}
		System.out.print(answer);
	}
}
