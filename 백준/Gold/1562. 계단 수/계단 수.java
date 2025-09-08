import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
 
		long MOD = 1000000000;
		int last = 1<<10;
 
		long[][][] nums = new long[N][10][last];
		for(int i=1;i<10;i++){
			nums[0][i][1<<i] = 1;
		}
 
		for(int i=1;i<N;i++){
			for(int j=0;j<10;j++){
				for(int k=0;k<last;k++){
					if(j==0){
						nums[i][j][k|1] = (nums[i][j][k|1] + nums[i-1][j+1][k])%MOD;
					}
					else if(j==9){
						nums[i][j][k|1<<9] = (nums[i][j][k|(1<<9)] + nums[i-1][j-1][k])%MOD;
					}
					else{
						nums[i][j][k|(1<<j)] = (nums[i][j][k|(1<<j)] + nums[i-1][j+1][k])%MOD;
						nums[i][j][k|(1<<j)] = (nums[i][j][k|(1<<j)] + nums[i-1][j-1][k])%MOD;
					}
				}
			}
		}
 
		long sum = 0;
		for (int i = 0; i < 10; i++) {
			sum = (sum + nums[N - 1][i][last-1]) % MOD;
		}
 
		System.out.println(sum);
	}
}
