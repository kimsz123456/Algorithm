import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        
        long sum1 = 0;
        long sum2 = 0;
        for(int i=0;i<queue1.length;i++){
            sum1+=queue1[i];
            sum2+=queue2[i];
        }
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();
        for(int i=0;i<queue1.length;i++){
            q1.add(queue1[i]);
            q2.add(queue2[i]);
        }
        while(sum1 != sum2) {
            if(answer > (queue1.length + queue2.length) * 2){
                return -1;   
            }
            int num = 0;
            if(sum1 < sum2) {
                num = q2.poll();
                q1.add(num);
                sum1 += (long) num;
                sum2 -= (long) num;
            }
            else if(sum1 > sum2) {
                num = q1.poll();
                q2.add(num);
                sum1 -= (long) num;
                sum2 += (long) num;
            }
            else 
            {
                return answer;
            }
            answer++;
        }
        return answer;
    }
}