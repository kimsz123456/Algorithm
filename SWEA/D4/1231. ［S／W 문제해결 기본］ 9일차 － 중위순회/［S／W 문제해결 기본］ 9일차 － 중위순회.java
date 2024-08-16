import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int T = 10; // 테스트 케이스 수
        
        for (int tc = 1; tc <= T; tc++) {
        	
        	int N = Integer.parseInt(br.readLine());
        	
        	String[] str = new String[N+1];
        	
        	for(int i=0;i<N;i++) {
        		StringTokenizer st = new StringTokenizer(br.readLine());
        		int num = Integer.parseInt(st.nextToken());
        		str[num]=st.nextToken();
        	}
        	System.out.print("#"+tc+" ");
            inorder(str, 1, N);
            System.out.println();
        }
    }
    
    public static void inorder(String[] str, int idx, int N) {
    	if (idx*2<=N) {
    		inorder(str,idx*2,N);
    	}
    	System.out.print(str[idx]);
    	if (idx*2+1<=N) {
    		inorder(str,idx*2+1,N);
    	}
    }
}