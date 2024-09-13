import java.util.*;

import javax.swing.plaf.basic.BasicProgressBarUI;

import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine()); // 정수의 개수

		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder()); // 홀수일 땐 여기가 더 사이즈가 커야함
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

		for (int i = 0; i < N; i++) {
			int next = Integer.parseInt(br.readLine());
			// 사이즈가 같으면
			if (maxHeap.size() == minHeap.size()) {
				// 최대힙이 비어있으면 추가
				if (maxHeap.size() == 0) {
					maxHeap.add(next);
				}
				// 비어있지 않으면 최대힙이나 최소힙에 추가
				else {
					if (maxHeap.peek() >= next) {
						maxHeap.add(next);
					} else {
						minHeap.add(next);
						maxHeap.add(minHeap.poll());
					}
				}

			}
			// 최대힙의 갯수가 더 많으면
			else {
				// 최대힙 또는 최소힙에 추가
				if (maxHeap.peek() > next) {
					maxHeap.add(next);
					minHeap.add(maxHeap.poll());
				} else {
					minHeap.add(next);
				}
			}
			sb.append(maxHeap.peek()).append("\n");
		}
		System.out.println(sb);
	}
}