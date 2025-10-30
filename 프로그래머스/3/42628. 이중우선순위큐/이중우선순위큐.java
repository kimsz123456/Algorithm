import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for(String operation : operations) {
            String[] order = operation.split(" ");
            int num = Integer.parseInt(order[1]);
            if(order[0].equals("I")) {
                maxHeap.add(num);
                minHeap.add(num);
            }
            else {
                if(maxHeap.size()==0) continue; 
                if(num==1){
                    int max = maxHeap.poll();
                    minHeap.remove(max);
                }
                else {
                    int min = minHeap.poll();
                    maxHeap.remove(min);
                }
            }
        }
        
        if (!maxHeap.isEmpty()) {
            answer[0] = maxHeap.peek();
            answer[1] = minHeap.peek();
        }
        
        return answer;
    }
}