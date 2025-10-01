import java.util.*;

class Solution {
    static class Job{
        int num;
        int req;
        int time;
        
        Job(int num,int req,int time){
            this.num = num;
            this.req = req;
            this.time = time;
        }
    }
    public int solution(int[][] jobs) {
        int N = jobs.length;
        
        PriorityQueue<Job> wq = new PriorityQueue<>((job1,job2)->{
            return Integer.compare(job1.req,job2.req);
        });
        PriorityQueue<Job> pq = new PriorityQueue<>((job1,job2)->{
            if(job1.time!=job2.time) return Integer.compare(job1.time,job2.time);
            if(job1.req!=job2.req) return Integer.compare(job1.req,job2.req);
            if(job1.num!=job2.num) return Integer.compare(job1.num,job2.num);
            return 0;
        });
        for(int i=0;i<N;i++){
            wq.add(new Job(i,jobs[i][0],jobs[i][1]));
        }
        
        int[] returnTime = new int[N];
        
        int now = 0;
        while(!wq.isEmpty() || !pq.isEmpty()){
            while(!wq.isEmpty() && now>=wq.peek().req){
                pq.add(wq.poll());
            }
            if (pq.isEmpty()) {
                now = wq.peek().req;
                continue;
            }
            
            Job cur = pq.poll();
            now += cur.time;
            returnTime[cur.num] = now-cur.req;
        }
        
        int sum = 0;
        for (int t : returnTime) sum += t;
        int answer = sum / N;
        return answer;
    }
}