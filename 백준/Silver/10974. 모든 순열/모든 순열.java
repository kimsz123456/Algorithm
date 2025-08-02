import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static boolean[] sel;
	static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = stoi(br.readLine());
        sel = new boolean[N+1];
        int[] arr = new int[N];
        comb(1,0,arr);
        System.out.print(sb);
    }
    
    public static void comb(int idx, int cnt,int[] arr) {
    	if(cnt==N) {
    		for(int i=0;i<N;i++) {
    			sb.append(arr[i]).append(" ");
    		}
    		sb.append("\n");
    		return;
    	}
    	
    	for(int i=1;i<=N;i++) {
    		if(!sel[i]){
    			sel[i]=true;
    			arr[cnt]=i;
    			comb(i,cnt+1,arr);
    			sel[i]=false;
    		}
    	}
    }
    
    public static int stoi(String str) {
    	return Integer.parseInt(str);
    }
}