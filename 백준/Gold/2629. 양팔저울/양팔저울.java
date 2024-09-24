import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] weight;
	static Set<Integer> set = new HashSet<>();
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		N =Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		
		weight = new int[N+1];
		for(int i=0;i<N;i++) {
			weight[i] = Integer.parseInt(st.nextToken());
		}
		visited = new boolean[N][15001];
		
		check(0,0);
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			if(set.contains(Integer.parseInt(st.nextToken()))){
				sb.append("Y");
			}
			else {
				sb.append("N");
			}
			sb.append(" ");
		}
		System.out.println(sb);
	}
	static void check(int count,int sum) {
		if(count==N) {
			set.add(sum);
			return;
		}
		if(visited[count][sum]) return;
        visited[count][sum] = true;
		
		check(count+1,sum+weight[count]);
		check(count+1,sum);
		check(count+1,Math.abs(sum-weight[count]));
		
	}
}