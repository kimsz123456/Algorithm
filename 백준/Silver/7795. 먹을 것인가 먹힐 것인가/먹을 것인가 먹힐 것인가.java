import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			List<Integer> listA = new ArrayList<>();
			List<Integer> listB = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			
			for(int i=0;i<N;i++) {
				listA.add(Integer.parseInt(st.nextToken()));
			}
			
			st = new StringTokenizer(br.readLine());
			
			for(int i=0;i<M;i++) {
				listB.add(Integer.parseInt(st.nextToken()));
			}
			
			Collections.sort(listB);
			
			int result = 0;
			
			for(int i=0;i<N;i++) {
				int A = listA.get(i);
				for(int j=0;j<M;j++) {
					int B = listB.get(j);
					if(A<=B) {
						break;
					}
					else { 
						result+=1;
					}
				}
			}
			
			System.out.println(result);
			
		}
		
		
		
	}
}
