import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(String time : timetable){
            int hour = Integer.parseInt(time.substring(0,2));
            int min = Integer.parseInt(time.substring(3,5));
            pq.add(hour*60+min);
        }
        
        int start = 9 * 60;
        int last = 0;
        int total = 0;
        for(int i = 0; i < n; i++) {
            total = 0;
            while(!pq.isEmpty()) {
                int cur = pq.peek();
                if(cur <= start && total < m) {
                    pq.poll();
                    total++;
                } else break;
                last = cur - 1;
            }
            start += t;
        }
        if(total < m) last = start - t;
        
        String hour = String.format("%02d", last / 60);
        String minute = String.format("%02d", last % 60);
        return hour + ":" + minute;
        
    }
}