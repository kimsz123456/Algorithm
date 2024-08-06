import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = 30;	// 30명
		boolean[] homework = new boolean[30];	// 기본은 과제를 안함
		
		for (int i = 0; i < T-2 ; i++) {
			int num = Integer.parseInt(br.readLine());	// 입력받은 번호는
			homework[num-1]=true;	// 과제 제출함
		}
		// 과제제출 안한사람
		for(int i=0; i<T;i++) {
			if (!homework[i]) {
				bw.write(String.valueOf(i+1));
				bw.newLine();
			}
		}
		
        br.close();
        bw.flush();
        bw.close();
	}
}
