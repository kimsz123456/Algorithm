import java.util.PriorityQueue;

public class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int s : scoville) {
            heap.offer(s);  // 모든 스코빌 지수를 우선순위 큐에 넣음
        }
        
        int cnt = 0;
        
        while (heap.peek() < K) {  // 가장 작은 값이 K보다 작을 때 반복
            if (heap.size() == 1) {  // 원소가 하나만 남았을 때도 K를 넘지 못하면
                return -1;  // -1 반환
            }
            
            int first = heap.poll();  // 가장 작은 값 꺼냄
            int second = heap.poll(); // 두 번째로 작은 값 꺼냄
            
            int ns = first + second * 2;  // 새 스코빌 지수 계산
            heap.offer(ns);  // 계산된 값을 다시 우선순위 큐에 넣음
            cnt++;  // 섞은 횟수 증가
        }
        
        return cnt;
    }
}
