import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        
        int[] arr = new int[N];
        int[] sort = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
        	int num = Integer.parseInt(st.nextToken());
        	arr[i] = num; 
        	sort[i] = num;
        }
        
        Arrays.sort(sort);
        
        Map<Integer,Integer> map = new HashMap<>();
        map.put(sort[0], 0);
        int rank=1;
        int index=1;
        for(int i=1;i<N;i++) {
        	if(sort[i]!=sort[i-1]) {
        		map.put(sort[index], rank);
        		rank++;
        	}
        	index++;
        }
        for(int i = 0; i < N; i++) {
			sb.append(map.get(arr[i])).append(" ");
		}
        System.out.println(sb);
    }
}