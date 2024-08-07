import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int arr[] = new int[8]; // 8개짜리 배열
		
		// 배열에 값 입력
		for (int i=0;i<8;i++) {
			arr[i]= Integer.parseInt(st.nextToken());
		}
		boolean ascending = true;
		boolean descending = true;
		
		for(int i=0;i<8;i++) {
			if(arr[0]==1) {
				if(i+1<8 && arr[i]>arr[i+1]) {
					System.out.println("mixed");
					ascending = false;
					descending = false;
					break;
				}
				else {
					descending = false;
				}
			}
			else if(arr[0]==8) {
				if(i+1<8 && arr[i]<arr[i+1]) {
					System.out.println("mixed");
					ascending = false;
					descending = false;
					break;
				}
				else {
					ascending = false;
				}
			}
			else {
				System.out.println("mixed");
				ascending = false;
				descending = false;
				break;
			}
		}
		if (ascending) {
			System.out.println("ascending");
		}
		else if(descending) {
			System.out.println("descending");
		}
	}
}