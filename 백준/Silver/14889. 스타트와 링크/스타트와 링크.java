import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static boolean[] selected;
	static int[][] ability;
	static int answer = Integer.MAX_VALUE;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        
        ability = new int[N][N];
        
        for(int i=0;i<N;i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0;j<N;j++) {
        		ability[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        selected = new boolean[N];
        teamBuild(0,0);
        
        System.out.println(answer);
    }
    
    public static void teamBuild(int idx, int count) {
    	if(count==N/2) {
    		score();
    		return;
    	}
    	
    	for(int i=idx;i<N;i++) {
    		if(!selected[i]) {
    			selected[i]=true;
    			teamBuild(i+1,count+1);
    			selected[i]=false;
    		}
    	}
    }
    
    public static void score() {
    	int start = 0;
    	int link = 0;
    	
    	for(int i = 0; i < N-1; i++) {
    		for(int j = i+1; j < N; j++) {
    			if(selected[i] && selected[j]) start += ability[i][j] + ability[j][i];
    			else if(!selected[i] && !selected[j]) link += ability[i][j] + ability[j][i];
    		}
    	}
    	answer = Math.min(answer, Math.abs(start - link));
    }
}