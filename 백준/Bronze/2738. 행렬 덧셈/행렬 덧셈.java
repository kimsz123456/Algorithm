import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st1 = new StringTokenizer(br.readLine()); 
		int N = Integer.parseInt(st1.nextToken());
		int M = Integer.parseInt(st1.nextToken());
		
		int[][] arr1 = new int[N][M];
		int[][] arr2 = new int[N][M];
		
		for (int i=0; i<N;i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for(int j=0; j<M;j++) {
				arr1[i][j]=Integer.parseInt(st2.nextToken());
			}
		}
		for (int i=0; i<N;i++) {
			StringTokenizer st3 = new StringTokenizer(br.readLine());
			for(int j=0; j<M;j++) {
				arr2[i][j]=Integer.parseInt(st3.nextToken());
			}
		}
		int[][] arr3 = new int[N][M];
		for (int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				arr3[i][j]=arr1[i][j]+arr2[i][j];
			}
		}
		for (int i=0; i<N;i++) {
			for(int j=0;j<M;j++) {
				bw.write(String.valueOf(arr3[i][j])+" ");
			}
			bw.newLine();
		}
		
        br.close();
        bw.flush();
        bw.close();
	}
}
