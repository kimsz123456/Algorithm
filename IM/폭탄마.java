import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    static int power;
	public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스
 
        for (int tc = 1; tc <= T; tc++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int N = Integer.parseInt(st.nextToken()); // 배열의 크기
        	int P = Integer.parseInt(st.nextToken()); // 폭탄의 파워
        	
        	int[][] arr = new int[N][N];
        	
        	for (int i=0;i<N;i++) {
        		StringTokenizer str = new StringTokenizer(br.readLine());
        		for(int j=0;j<N;j++) {
        			arr[i][j] = Integer.parseInt(str.nextToken());
        		}
        	}
        	
        	int power=0;
        	for (int r=0;r<N;r++) {
        		for (int c=0;c<N;c++) {
        			power = Math.max(plus(r,c,arr,P,N),power);
        			power = Math.max(x(r,c,arr,P,N),power);
        		}
        	}
        	System.out.println("#"+tc+" "+power);
        }
    }
    public static int plus(int r,int c,int[][] arr,int P,int N) {
    	power = 0;
    	for(int i=r-P;i<=r+P;i++) {
    		if (i==r) {
    			for(int j=c-P;j<=c+P;j++) {
        			if(i>=0 && i<N && j>=0 && j<N)
    				power += arr[i][j];
        		}
    		}
    		for(int j=c-P;j<=c+P;j++) {
    			if(j==c) {
    				if(i>=0 && i<N && j>=0 && j<N)
    				power += arr[i][j];
    			}
    		}
    	}
    	return power-arr[r][c];
    }
    public static int x(int r,int c,int[][] arr,int P,int N) {
    	power = 0;
    	for(int i=r-P;i<=r+P;i++) {
    		for(int j=c-P;j<=c+P;j++) {
        		if((i-j==r-c) || (i+j==r+c)) {
        			if(i>=0 && i<N && j>=0 && j<N)
        			power += arr[i][j];
        		}
        	}
    	}
    	return power;
    }
}
