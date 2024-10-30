import java.io.*;
import java.util.*;

public class Main {
	static int N,M;
	static int[][] map;
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new int[N][M];
        for(int i=0;i<N;i++) {
        	String str = br.readLine();
        	for(int j=0;j<M;j++) {
        		map[i][j] = str.charAt(j)-'0';
        	}
        }
        
        System.out.println(bfs());
    }
    
    static int bfs() {
    	Queue<int[]> queue = new ArrayDeque<>();
    	boolean[][][] visited = new boolean[N][M][2];
    	queue.add(new int[] {0,0,0,1});
    	visited[0][0][0]=true;
    	
    	while(!queue.isEmpty()) {
    		int[] cur = queue.poll();
    		int dist = cur[3];
    		if(cur[0]==N-1 && cur[1]==M-1) {
    			return cur[3];
    		}
    		
    		for(int d=0;d<4;d++) {
    			int nextr = cur[0]+dr[d];
    			int nextc = cur[1]+dc[d];
    			if(nextr<N && nextr>=0 && nextc<M && nextc>=0) {
    				if(map[nextr][nextc]==0 && !visited[nextr][nextc][cur[2]]) {
    					queue.add(new int[] {nextr,nextc,cur[2],dist+1});
    					visited[nextr][nextc][cur[2]]=true;
    				}
    				if(map[nextr][nextc]==1 && cur[2]==0 && !visited[nextr][nextc][cur[2]]) {
    					queue.add(new int[] {nextr,nextc,cur[2]+1,dist+1});
    					visited[nextr][nextc][cur[2]+1]=true;
    				}
    			}
    		}
    	}
    	return -1;
    }
}