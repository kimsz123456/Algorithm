import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] stat = new int[N];
		int[] count = new int[8001];
		int sum = 0;
		for(int i=0;i<N;i++) {
			int num = Integer.parseInt(br.readLine());
			stat[i]= num;
			sum +=num;
			count[num+4000]++;
		}
		Arrays.sort(stat);
		// 산술평균
		int mean = (int) Math.round((double)sum/N);
		int median = stat[N/2];
		int mode = 0;
		int max=0;
		boolean flag=false;
		for(int i=0;i<=8000;i++) {
			if(count[i]>max) {
				max=count[i];
				mode=i-4000;
				flag=true;
			}
			else if(count[i]==max && flag) {
				mode=i-4000;
				flag=false;
			}
		}
		int range = Math.abs(stat[N-1]-stat[0]);
		
		sb.append(mean).append("\n");
		sb.append(median).append("\n");
		sb.append(mode).append("\n");
		sb.append(range).append("\n");
		System.out.println(sb);
	}
}