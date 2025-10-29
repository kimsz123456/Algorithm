import java.util.*;

class Solution {
    public int solution(int bridge_length, int max, int[] truck_weights) {
        int N = truck_weights.length;
        
        Queue<int[]> q = new ArrayDeque<>();
        int time = 0;
        int weight = 0;
        for(int i=0;i<N;i++){
            int truck = truck_weights[i];
            while(!q.isEmpty() && q.peek()[1]<=time) {
       			weight-=q.poll()[0];
            }
            if(weight+truck<=max) {
                q.add(new int[] {truck,time+bridge_length+1});
                weight+=truck;
                time++;
            }
            else{
                while(weight+truck>max) {
        			int[] out = q.poll();
        			time = out[1];
        			weight -= out[0];
        		}
        		q.add(new int[] {truck,time+bridge_length});
        		weight +=truck;
            }
        }
        while(!q.isEmpty()) {
        	time = q.poll()[1];
        }
        return time;
    }
}