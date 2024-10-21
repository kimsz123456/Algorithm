import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		int[][] cost = new int[N + 1][3];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		
		for(int i=1;i<=N;i++) {
			for(int j=0;j<3;j++) {
				cost[i][j] += Math.min(cost[i-1][(j+1)%3],cost[i-1][(j+2)%3]);
			}
		}
		System.out.println(Math.min(Math.min(cost[N][0],cost[N][1]),cost[N][2]));
	}
}