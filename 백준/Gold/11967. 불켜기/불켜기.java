import java.util.*;
import java.io.*;

public class Main {
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        List<int[]>[][] lights = new ArrayList[N+1][N+1];
        
        for(int i=1;i<=N;i++) {
        	for(int j=1;j<=N;j++) {
        		lights[i][j] = new ArrayList<>();
        	}
        }
        for(int i=0;i<M;i++) {
        	st = new StringTokenizer(br.readLine());
        	int x = Integer.parseInt(st.nextToken());
        	int y = Integer.parseInt(st.nextToken());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	lights[x][y].add(new int[] {a,b});
        }
        
        boolean[][] visited = new boolean[N+1][N+1];
        boolean[][] lighton = new boolean[N+1][N+1];
        
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {1,1});
        visited[1][1]=true;
        lighton[1][1]=true;
        
        int result = 1;
        while(!queue.isEmpty()) {
        	int[] cur = queue.poll();
        	int r = cur[0];
        	int c = cur[1];
        	for(int[] light : lights[r][c]) {
        		if(!lighton[light[0]][light[1]]) {
        			result++;
        			lighton[light[0]][light[1]]=true;
        			for(int d=0;d<4;d++) {
                		int nr = light[0]+dr[d];
                		int nc = light[1]+dc[d];
                		if(nr>0 && nr<=N && nc>0 && nc<=N && visited[nr][nc] && lighton[nr][nc]) {
                			queue.add(new int[]{nr,nc});
                		}
        			}
        		}
			}
        	
        	for(int d=0;d<4;d++) {
        		int nr = r+dr[d];
        		int nc = c+dc[d];
        		if(nr>0 && nr<=N && nc>0 && nc<=N && !visited[nr][nc] && lighton[nr][nc]) {
        			queue.add(new int[]{nr,nc});
        			visited[nr][nc]=true;
        		}
        	}
        }
        System.out.println(result);
    }
}
