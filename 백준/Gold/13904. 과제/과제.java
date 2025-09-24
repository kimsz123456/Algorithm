import java.io.*;
import java.util.*;

public class Main {
	static class Work {
		int deadline;
		int score;
		Work(int deadline, int score) {
			this.deadline = deadline;
			this.score = score;
		}
	}
    public static void main(String[] args) throws IOException {
    	int N = nextInt();
    	List<Work> list = new ArrayList<>();
    	int maxDay = 0;
    	for(int i=0;i<N;i++) {
    		int deadline = nextInt();
    		int score = nextInt();
    		list.add(new Work(deadline,score));
    		maxDay = Math.max(maxDay, deadline);
    	}
    	list.sort(Comparator.comparingInt(w -> w.deadline));
    	PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    	int answer = 0;
    	int idx = list.size()-1;
    	for(int day=maxDay;day>0;day--) {
    		while(idx>=0 && list.get(idx).deadline >= day) {
    			pq.add(list.get(idx).score);
    			idx--;
    		}
    		if(!pq.isEmpty()) {
    			answer += pq.poll();
    		}
    	}
    	System.out.print(answer);
    }
    static int nextInt() throws IOException {
        int c;
        while (!Character.isDigit(c = System.in.read()));
        int value = c & 15;
        while (Character.isDigit(c = System.in.read())) {
            value = value * 10 + (c & 15);
        }
        return value;
    }
}