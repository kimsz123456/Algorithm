import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for(int tc=1; tc<=T;tc++) {
        	
        	int N = Integer.parseInt(br.readLine());
        	
        	Map<String,Integer> map = new HashMap<>();
        	
        	for(int i=0;i<N;i++) {
        		st = new StringTokenizer(br.readLine());
        		st.nextToken();
        		String str = st.nextToken();
        		map.put(str, map.getOrDefault(str, 0)+1);
        	}
        	
        	int result = 1;
        	
        	for (int num : map.values()) {
        		result *=(num+1);
        	}
        	
        	sb.append(result-1).append("\n");
        }
        System.out.println(sb);
    }
}