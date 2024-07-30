import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		for (int tc=1; tc<11; tc++) { // 10개의 테스트케이스
			int dump = sc.nextInt(); // 첫번째 입력받는 덤프횟수
			int[] arr = new int[100]; // 가로길이 100의 상자의 높이
			
			// 상자갯수 배열을 입력받음
			for(int i=0; i<100;i++) { 
				arr[i]=sc.nextInt();
			}
			
			// dumping 메서드를 dump횟수만큼 반복
			for(int i=0; i<dump;i++) {
				dumping(arr);
			}
			
			// dumping 후의 최대값과 최소값을 뺌
			int max = 0;
			int min = 100;
			for(int i =0; i<arr.length;i++) {
				if(max<arr[i]) {
					max=arr[i];
				}
				if(min>arr[i]) {
					min=arr[i];
				}
			}
			System.out.println("#" + tc + " " +(max-min));
		}
	}
	static void dumping(int[] arr) {
		int max = 0; // 배열의 최대값
		int min = 100; // 배열의 최소값
		
		// 배열의 최대값과 최소값
		for(int i=0;i<arr.length;i++) {
			if (max < arr[i]) {
				max = arr[i];
			}
			if (min > arr[i]) {
				min = arr[i];
			}
		}
		// 최대값에서 최소값으로 상자를 옮김
		if(max-min > 2) {
			for(int i=0;i<arr.length;i++) {
				if (arr[i]==max) {
					arr[i]--;
					break;
				}
			}
			for(int i=0;i<arr.length;i++){
				if (arr[i]==min) {
					arr[i]++;
					break;
				}
			}
		}
		else {
			System.out.println(max-min);
		}
	}
}
