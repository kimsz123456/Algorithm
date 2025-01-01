import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		List<Integer> cranes = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			cranes.add(Integer.parseInt(st.nextToken()));
		}
		int M = Integer.parseInt(br.readLine());
		List<Integer> boxes = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			boxes.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(cranes,Collections.reverseOrder());
		Collections.sort(boxes,Collections.reverseOrder());
		if(cranes.get(0)<boxes.get(0)) {
			System.out.println(-1);
		}
		else {
			int time = 0;
			while(!boxes.isEmpty()) {
				int idx = 0;
				for(int i=0;i<cranes.size();i++) {
					if(idx==boxes.size()) break;
					else if(cranes.get(i)>=boxes.get(idx)) {
						boxes.remove(idx);
					}
					else {
						idx++;
						i--;
					}
				}
				time++;
			}
			System.out.println(time);
		}
	}
}