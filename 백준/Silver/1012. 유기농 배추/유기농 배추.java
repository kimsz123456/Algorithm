import java.io.*;
import java.util.*;

public class Main {
	static int N,M;
	static boolean[][] farm;
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        for(int tc = 1; tc<=T;tc++) {
        	st = new StringTokenizer(br.readLine());
        	
        	M = Integer.parseInt(st.nextToken());
        	N = Integer.parseInt(st.nextToken());
        	int K = Integer.parseInt(st.nextToken());
        	
        	farm = new boolean[N][M];
        	
        	for(int i=0;i<K;i++) {
        		st = new StringTokenizer(br.readLine());
        		
        		int x = Integer.parseInt(st.nextToken());
        		int y = Integer.parseInt(st.nextToken());
        		
        		farm[y][x]=true;
        	}
        	
        	sb.append(bfs()).append("\n");
        }
        System.out.println(sb);
    }
    static int bfs() {
    	Queue<int[]> queue = new ArrayDeque<>();
    	int result=0;
    	for(int i=0;i<N;i++) {
    		for(int j=0;j<M;j++) {
    			if(farm[i][j]) {
    				queue.add(new int[] {i,j});
    				farm[i][j]=false;
    				
    				while(!queue.isEmpty()) {
    					int[] current = queue.poll();
    					
    					for(int d=0;d<4;d++) {
    						int nextr = current[0]+dr[d];
    						int nextc = current[1]+dc[d];
    						
    						if(nextr>=0 && nextr<N && nextc>=0 && nextc<M && farm[nextr][nextc]) {
    							queue.add(new int[] {nextr,nextc});
    							farm[nextr][nextc]=false;
    						}
    					}
    				}
    				result++;
    			}
    		}
    	}
    	return result;
    }
}
