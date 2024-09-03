import java.io.*;
import java.util.*;

public class Solution{
	static int N, res;
	static int[] arr,selected;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1 ; tc<=T ; tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N];
			selected = new int[N];
			visited = new boolean[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int i =0 ; i < N ; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			res = 0;
			perm(0);
			
			sb.append("#").append(tc).append(" ").append(res).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	private static void perm(int cnt) {
		if(cnt == N) {
			check(0,0,0);
		}
		for(int i = 0 ; i < N ; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			selected[cnt] = arr[i];
			perm(cnt+1);	
			visited[i] = false;
		}
	}
	
	private static void check(int cnt, int left, int right) {
		if(left<right) return;
		if(cnt == N) {
			res++;
			return;
		}
		check(cnt+1, left, right+selected[cnt]);
		check(cnt+1, left+selected[cnt], right);
	}
}