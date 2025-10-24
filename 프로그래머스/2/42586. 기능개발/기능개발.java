import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new ArrayDeque<>();
        int N = progresses.length;
        for(int i=0;i<N;i++) {
            int progress = progresses[i];
            int speed = speeds[i];
            int day = ((100-progress)%speed==0)?((100-progress)/speed):((100-progress)/speed+1);
            q.add(day);
        }
        List<Integer> list = new ArrayList<>();
        
        int before=q.poll();
        int count=1;
        boolean last = false;
        while(!q.isEmpty()) {
            int day = q.poll();
            if(before>=day) {
                count++;
            }
            else {
                before = day;
                list.add(count);
                count = 1;
            }
        }
        list.add(count);
        
        int[] answer = new int[list.size()];
        for(int i=0;i<list.size();i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}