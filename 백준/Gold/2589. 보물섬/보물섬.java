import java.io.*;
import java.util.*;

public class Main {
	static int r,c;
	static char[][] map;
	static boolean[][] checked,visited;
	static Queue<int[]> queue;
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	static int result = 0;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		map = new char[r][c];
		checked = new boolean[r][c];
		
		for(int i=0;i<r;i++) {
			String str = br.readLine();
			for(int j=0;j<c;j++) {
				char character = str.charAt(j);
				map[i][j] = character;
				if(character=='W') {
					checked[i][j]=true;
				}
			}
		}
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(!checked[i][j]) {
					bfs(i,j);
					checked[i][j]=true;
				}
			}
		}
		System.out.println(result);
	}
	
	static void bfs(int row,int col) {
		queue = new ArrayDeque<>();
		visited = new boolean[r][c];
		
		queue.add(new int[] {row,col,0});
		visited[row][col]=true;
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			for(int d=0;d<4;d++) {
				int nextr = current[0]+dr[d];
				int nextc = current[1]+dc[d];
				int nextnum = current[2]+1;
				if(nextr >=0 && nextr < r && nextc >=0 && nextc <c && !visited[nextr][nextc] && map[nextr][nextc]=='L') {
					queue.add(new int[] {nextr,nextc,nextnum});
					visited[nextr][nextc]=true;
					result = Math.max(result, nextnum);
				}
			}
		}
	}
}