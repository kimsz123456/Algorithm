import java.io.*;
import java.util.*;

public class Main {
	static int[] dwarfs = new int[9];
	static boolean[] visited = new boolean[9];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int i=0;i<9;i++) {
			dwarfs[i]=stoi(br.readLine());
		}
		
		comb(0,0,0);
	}
	public static void comb(int idx,int cnt, int sum) {
		if(cnt>7 || sum>100) {
			return;
		}
		if(cnt==7 && sum==100) {
			for(int i=0;i<9;i++) {
				if(visited[i]) {
					System.out.println(dwarfs[i]);
				}
			}
			return;
		}
		for(int i=idx;i<9;i++) {
			if(!visited[i]) {
				visited[i]=true;
				comb(i,cnt+1,sum+dwarfs[i]);
				visited[i]=false;
			}
		}
	}
	
	public static int stoi(String str) {
		return Integer.parseInt(str);
	}
}