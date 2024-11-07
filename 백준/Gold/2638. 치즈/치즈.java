import java.util.*;
import java.io.*;

public class Main {
	static int N,M;
	static int[][] cheese,air;
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        cheese = new int[N][M];
        
        for(int i=0;i<N;i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0;j<M;j++) {
        		cheese[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        int result = 0;
        while(!bfs()) {
        	for(int i=0;i<N;i++) {
        		for(int j=0;j<M;j++) {
        			if(air[i][j]>=2) {
        				cheese[i][j]=0;
        			}
        		}
        	}
        	result++;
        }
        System.out.println(result);
    }
    
    static boolean bfs() {
    	Queue<int[]> queue = new ArrayDeque<>();
    	air = new int[N][M];
    	queue.add(new int[] {0,0});
    	air[0][0]=-1;
    	
    	int count = 1;
    	while(!queue.isEmpty()) {
    		int[] now = queue.poll();
    		for(int d=0;d<4;d++) {
    			int r = now[0]+dr[d];
    			int c = now[1]+dc[d];
    			if(r<0 || r>=N || c<0 || c>=M) continue;
    			if(cheese[r][c]==1) {
    				air[r][c]++;
    			}
    			if(cheese[r][c]==0 && air[r][c]==0) {
    				count++;
    				air[r][c]=-1;
    				queue.add(new int[] {r,c});
    			}
    		}
    	}
    	return count==N*M;
    }
}
