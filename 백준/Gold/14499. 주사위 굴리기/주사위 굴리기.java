import java.util.*;
import java.io.*;

public class Main {
	static int[] dr = {0,0,-1,1};
	static int[] dc = {1,-1,0,0};
	static int N,M,r,c;
	static int[] dice = new int[7];
	static int[][] map;
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<K;i++) {
			int d = Integer.parseInt(st.nextToken());
			move(d);
		}
	}
	static void move(int d) {
		int nr = r+dr[d-1];
		int nc = c+dc[d-1];
		if(nr>=0 && nr<N && nc>=0 && nc<M) {
			roll(d,nr,nc);
			r = nr;
			c = nc;
		}
	}
	
	static void roll(int d, int r, int c) {
		int tmp = dice[1];
		switch(d) {
		case 1:
			dice[1] = dice[4];
			dice[4] = dice[6];
			dice[6] = dice[3];
			dice[3] = tmp;
			break;
		case 2:
			dice[1] = dice[3];
			dice[3] = dice[6];
			dice[6] = dice[4];
			dice[4] = tmp;
			break;
		case 3:
			dice[1] = dice[2];
			dice[2] = dice[6];
			dice[6] = dice[5];
			dice[5] = tmp;
			break;
		case 4:
			dice[1] = dice[5];
			dice[5] = dice[6];
			dice[6] = dice[2];
			dice[2] = tmp;
			break;
		}
		if(map[r][c]==0) {
			map[r][c] = dice[6];
		}
		else {
			dice[6] = map[r][c];
			map[r][c] = 0;
		}
		System.out.println(dice[1]);
	}
}