import java.io.*;
import java.util.*;

public class Solution {
	static int N,length,endr,endc;
	static int[] dr= {-1,1,1,-1};
	static int[] dc = {1,1,-1,-1};
	static boolean[] counted;
	static int[][] cafe;
	static boolean[][] visited;
	static int result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());

			cafe = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					cafe[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			result = -1;
			for(int i=1;i<N-1;i++) {
				for(int j=0;j<N-2;j++) {
					visited = new boolean[N][N];
					counted = new boolean[101];
					endr = i;
					endc = j;
					bfs(i,j,0,0);
				}
			}
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}

    static void bfs(int r, int c, int dir, int length) {
        int nextr = r + dr[dir];
        int nextc = c + dc[dir];
        
        // 경계넘으면 return
        if (nextr < 0 || nextr >= N || nextc < 0 || nextc >= N || visited[nextr][nextc] || counted[cafe[nextr][nextc]]) {
            return;
        }
        
        // dir==3이면 직진쭉해서 원점으로오는지만 확인
        if (nextr == endr && nextc == endc && dir == 3) {
            result = Math.max(result, length + 1);
            return;
        }
        
        // 방문체크
        visited[nextr][nextc] = true;
        counted[cafe[nextr][nextc]] = true;

        // 직진
        bfs(nextr, nextc, dir, length + 1);

        // 방향전환
        if(dir<3) {
        	bfs(nextr, nextc, dir + 1, length + 1);
        }
        
        // 백트래킹
        visited[nextr][nextc] = false;
        counted[cafe[nextr][nextc]] = false;
    }
}
