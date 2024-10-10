import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				int num = Integer.parseInt(st.nextToken());
				map[i][j] = num;
				min = Math.min(min, num);
				max = Math.max(max, num);
			}                                                         
		}
		int time=Integer.MAX_VALUE;
		int height= Integer.MIN_VALUE;
		for(int i=min;i<=max;i++) {
			int count = 0;
			int block = B;
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < M; c++) {
					if(i < map[r][c]) {
						count += ((map[r][c] - i) * 2);
						block += (map[r][c] - i);
					//낮을 경우 블록은 제거, 시간은 1배
					}else {
						count += (i - map[r][c]);
						block -= (i - map[r][c]);
					}
				}
			}
				
			if(block<0) {
				break;
			}
			if(time>=count) {
				time=count;
				height=i;
			}
		}
		sb.append(time).append(" ").append(height);
		System.out.println(sb);
	}
} 