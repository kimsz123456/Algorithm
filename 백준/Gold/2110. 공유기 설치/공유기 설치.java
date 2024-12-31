import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] router = new int[N];
        for(int i=0;i<N;i++) {
        	router[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(router);
        
        int left = 1;
        int right = router[N-1]-router[0]+1;
        int mid, count;
        while(left<=right) {
        	mid = (left+right)/2;
        	count = 1;
        	int now = router[0];
            for(int i=1;i<N;i++){
               if(router[i]-now<mid) continue;
               count++;
               now = router[i];
            }
            if(count>=C) left = mid+1;
            else right = mid-1;
        	
        }
        System.out.println(right);
    }
}