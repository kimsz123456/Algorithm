import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        
        PriorityQueue<Integer> pospq = new PriorityQueue<>();
        PriorityQueue<Integer> negpq = new PriorityQueue<>(Collections.reverseOrder());
        
        
        for(int i=0;i<N;i++) {
            int num = Integer.parseInt(br.readLine());
            if(num==0) {
                if(!pospq.isEmpty() || !negpq.isEmpty()) {
                    if(pospq.isEmpty()) {
                    	int neg = negpq.poll();
                    	sb.append(neg).append("\n");
                    }
                    else if(negpq.isEmpty()) {
                    	int pos = pospq.poll();
                    	sb.append(pos).append("\n");
                    }
                    else {
                    	int neg = negpq.peek();
                    	int pos = pospq.peek();
                    	if(pos < Math.abs(neg)) {
                    		sb.append(pos).append("\n");
                    		pospq.poll();
                    	}
                    	else {
                    		sb.append(neg).append("\n");
                    		negpq.poll();
                    	}
                    }
                }
                else {
                    sb.append("0\n");
                }
            }
            else if(num>0){
                pospq.add(num);
            }
            else {
                negpq.add(num);
            }
        }
        System.out.println(sb);
    }
}