import java.util.*;
import java.io.*;
 
public class Main {
	
	final static long MOD = 1000000007;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
/*
                n
       | 1   1 |    | F(n+1)  F(n)  |
 A^n = |       |  = |               |
       | 1   0 |    |  F(n)  F(n-1) |

*/
		
		long[][] A = {{1, 1} , {1, 0}};
		
		long N = Long.parseLong(br.readLine());
		
		System.out.println(pow(A, N - 1)[0][0]);
		
	}
	
	// 분할정복을 통한 행렬 거듭제곱
	public static long[][] pow(long[][] A, long exp) {
		
		long[][] result = new long[2][2];
		for(int i=0;i<2;i++) {
			result[i][i]=1;
		}
		long[][] base = A;
		while(exp>0) {
			if(exp%2==1) {
				result = multiply(result,base);
			}
			base=multiply(base,base);
			exp /=2;
		}
		
		return result;
	}
	
	// 행렬 곱셈
	public static long[][] multiply(long[][] o1, long[][] o2) {
		
		long[][] product = new long[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    product[i][j] += (o1[i][k] * o2[k][j]);
                    product[i][j] %= MOD;
                }
            }
        }
        return product;
	}
 
}