import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = stoi(br.readLine());
        int[] arr = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
        	arr[i] = stoi(st.nextToken());
        }
        
        Arrays.sort(arr);
        long answer = 0;
        long prev=0;
        for(int i=0;i<N;i++) {
        	prev +=Math.abs(arr[i]-arr[0]);
        }
        answer+=prev;
        for(int i =1; i<N;i++)
    	{
    		long diff = arr[i] - arr[i - 1];
    		answer += prev + (diff * i) - (diff * (N - i));
    		prev = prev + (diff * i) - (diff * (N - i));
    	}
        System.out.print(answer);
    }
    
    public static int stoi(String str) {
    	return Integer.parseInt(str);
    }
}