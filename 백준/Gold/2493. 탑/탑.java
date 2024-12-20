import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        
        Stack<int[]> stack = new Stack<>();
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			if(stack.isEmpty()) {
				sb.append(0+" ");
			}
			else{
				while(true) {
					int[] data = stack.peek();
					int idx = data[0];
					int height = data[1];
					if(height > num) {
						sb.append(idx+" ");
						break;
					}else {
						stack.pop();
					}
					
					if(stack.isEmpty()) {
						sb.append(0+" ");
						break;
					}
				}
			}
			stack.push(new int[] {i+1, num});
		}
		System.out.println(sb.toString());
    }
}
