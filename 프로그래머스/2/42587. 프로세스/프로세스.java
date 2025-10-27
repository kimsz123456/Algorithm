import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int N = priorities.length;
        
        int[] answer = new int[N];
        Queue<int[]> q = new ArrayDeque<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<N;i++) {
            q.add(new int[] {priorities[i],i});
            pq.add(priorities[i]);
        }
        for(int i=0;i<N;i++){
            while(pq.peek()!=q.peek()[0]) {
                q.add(q.poll());
            }
            pq.poll();
            answer[q.poll()[1]]=i+1;
        }
        return answer[location];
    }
}