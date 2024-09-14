import java.io.*;
import java.util.*;

public class Main {
    static int[] bridge = new int[1004];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        
        Queue<int[]> queue = new ArrayDeque<>();
        
        int time = 0; // 현재시간
        int weight = 0; //
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
        	int truck = Integer.parseInt(st.nextToken()); // 트럭 무게
        	// 현재시간 기준 내릴거 내리기
        	while(!queue.isEmpty()&& queue.peek()[1]<=time) {
       			int[] out = queue.poll();
       			weight-=out[0];
       		}
        	// 올라갈 수 있으면
        	if(weight+truck<=L) {
        		queue.add(new int[] {truck,time+W+1});
        		weight+=truck;
        		time++;
        	}
        	// 올라갈 수 없으면
        	else {
        		// 트럭 나갈때 까지 시간이 지나야함.
        		while(weight+truck>L) {
        			int[] out = queue.poll();
        			time = out[1];
        			weight -= out[0];
        		}
        		// 빠짐과 동시에 다리에 올라갈 수 있음
        		queue.add(new int[] {truck,time+W});
        		weight +=truck;
        	}
        }
        while(!queue.isEmpty()) {
        	time = queue.poll()[1];
        }
        System.out.println(time);
    }
}