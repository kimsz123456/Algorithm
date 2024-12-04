import java.io.*;
import java.util.*;

public class Main {
	static int R,C,T;
	static int result;
	static int[][] map;
	static List<int[]> cleaner = new ArrayList<>();
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        
        map = new int[R][C];
        for(int i=0;i<R;i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0;j<C;j++) {
        		int dust = Integer.parseInt(st.nextToken());
        		map[i][j]=dust;
        		if(dust==-1) {
        			cleaner.add(new int[] {i,j});
        		}
        		else {
        			result+=dust;
        		}
        	}
        }
        task(0);
    }
	
	static void task(int t) {
		if(t==T) {
			System.out.print(result);
			return;
		}
		map = difussing(map);
		result = cleaning();
		task(t+1);
	}
	
	static int[][] difussing(int[][] map) {
		int[][] temp = new int[R][C];
	    for (int i = 0; i < R; i++) {
	        temp[i] = map[i].clone();
	    }
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(map[i][j]>0) {
					for(int d=0;d<4;d++) {
						int nr = i+dr[d];
						int nc = j+dc[d];
						if(nr>=0 && nr<R && nc>=0 && nc<C && map[nr][nc]!=-1) {
							temp[nr][nc] += map[i][j]/5;
							temp[i][j] -= map[i][j]/5;
						}
					}
				}
			}
		}
		return temp;
	}
	
	static int cleaning() {
		Queue<Integer> queue = new ArrayDeque<>();
		int[] upper = cleaner.get(0);
		int d=0;
		int r = upper[0];
		int c = upper[1];
		int nr = r;
		int nc = c;
		while(true) {
			if(nr+dr[d]<0 || nr+dr[d]>r || nc+dc[d]<0 || nc+dc[d]>=C) {
				d=(d+1)%4;
			}
			nr = nr+dr[d];
			nc = nc+dc[d];
			if(nr==r&&nc==c) {
				queue.poll();
				queue.add(0);
				break;
			}
			queue.add(map[nr][nc]);
		}
		nr = r;
		nc = c;
		while(true) {
			if(nr+dr[d]<0 || nr+dr[d]>r || nc+dc[d]<0 || nc+dc[d]>=C) {
				d=(d+1)%4;
			}
			nr = nr+dr[d];
			nc = nc+dc[d];
			if(nr==r&&nc==c) {
				break;
			}
			int num = queue.poll();
			map[nr][nc]=num;
		}
		int[] lower = cleaner.get(1);
		r = lower[0];
		c = lower[1];
		d = 2;
		nr = r;
		nc = c;
		while(true) {
			if(nr+dr[d]<r || nr+dr[d]>=R || nc+dc[d]<0 || nc+dc[d]>=C) {
				d=(d+3)%4;
			}
			nr = nr+dr[d];
			nc = nc+dc[d];
			if(nr==r&&nc==c) {
				queue.poll(); 
				queue.add(0);
				break;
			}
			queue.add(map[nr][nc]);
		}
		while(true) {
			if(nr+dr[d]<r || nr+dr[d]>=R || nc+dc[d]<0 || nc+dc[d]>=C) {
				d=(d+3)%4;
			}
			nr = nr+dr[d];
			nc = nc+dc[d];
			if(nr==r&&nc==c) {
				break;
			}
			map[nr][nc]=queue.poll();
		}
		int sum = 0;
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(map[i][j]!=-1) {
					sum+=map[i][j];
				}
			}
		}
		return sum;
	}
}
