import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] dr = {0,0};
	static int[] dc = {-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st1 = new StringTokenizer(br.readLine());

		int H = Integer.parseInt(st1.nextToken());
		int W = Integer.parseInt(st1.nextToken());

		StringTokenizer st2 = new StringTokenizer(br.readLine());
		int[][] arr = new int[H][W];
		
		
		for(int j=0;j<W;j++) {
			int wall = Integer.parseInt(st2.nextToken());
			for(int i=H-1;i>H-1-wall;i--) {
				arr[i][j]=1;
			}
		}
		boolean check = false;
		int result = 0;
		for(int i=0;i<H;i++) {
			for(int j=0;j<W;j++) {
				check=false;
				if(arr[i][j]==0) {
					int c = j;
					while(c+dc[0]>=0) {
						c = c+dc[0];
						if(arr[i][c]==1) {
							check=true;
							break;
						}
						else {
							check=false;
						}
					}
					if (check) {
						while(c+dc[1]<W) {
							c = c+dc[1];
							if(arr[i][c]==1) {
								check=true;
								break;
							}
							else {
								check=false;
							}
						}
					}
					else {
						continue;
					}
					if(check) {
						arr[i][j]=2;
						result++;
					}
				}
				else {
					continue;
				}
			}
		}
		System.out.print(result);
	}
}
