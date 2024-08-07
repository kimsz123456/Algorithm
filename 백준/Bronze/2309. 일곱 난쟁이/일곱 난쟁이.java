import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int sum = 0; // 난쟁이들 키의 총합
		int[] length = new int[9];
		
		// 난쟁이들의 키를 배열에 저장하고, 키의 총합을 구한다.
		for(int i=0;i<9;i++) {
			length[i] = Integer.parseInt(br.readLine());
			sum += length[i];
		}
		
		// 배열을 돌면서 두 난쟁이의 키의 합이 sum-100이 되는 난쟁이쌍을 찾는다.
		int lier1=0;
		int lier2=0;
		for (int i=0;i<9;i++) {
			for(int j=8;j>i;j--) {
				if (length[i] + length[j] == sum-100) {
					lier1=length[i];
					lier2=length[j];
					break;
				}
			}
		}
		// 두 난쟁이를 제외하고 출력, 출력전에 sort
		Arrays.sort(length);
		for (int i=0;i<9;i++) {
			if (length[i]!=lier1 && length[i]!=lier2) {
				System.out.println(length[i]);
			}
		}
	}
}