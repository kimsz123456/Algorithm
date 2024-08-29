import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static int[][] arr;
	static boolean[] col,leftdiagonal,rightdiagonal;
	static int result;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int T = Integer.parseInt(br.readLine());
    	
    	for(int tc=1;tc<=T;tc++) {
    		int N = Integer.parseInt(br.readLine());
    		
    		arr = new int[N][N];
    		col = new boolean[N];
    		leftdiagonal = new boolean[2*N-1];
    		rightdiagonal = new boolean[2*N-1];
    		result=0;
    		nqueen(0,N);
    		System.out.println("#"+tc+" "+result);
    	}
    }
    
    public static void nqueen(int row, int N) {
    	if(row==N) {
    		result++;
    		return;
    	}
    	for(int i=0;i<N;i++) {
    		if(!col[i]&&!leftdiagonal[N-1-row+i]&&!rightdiagonal[row+i]) {
    			col[i]=true;
    			leftdiagonal[N-1-row+i]=true;
    			rightdiagonal[row+i]=true;
    			nqueen(row+1,N);
    			col[i]=false;
    			leftdiagonal[N-1-row+i]=false;
    			rightdiagonal[row+i]=false;
    		}
    	}
    }
}