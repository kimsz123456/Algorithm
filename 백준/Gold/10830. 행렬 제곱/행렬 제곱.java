import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int MOD = 1000;
    static int[][] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        
        A = new int[N][N];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int[][] result = pow(A, B);
        
        // 출력할 때 각 원소를 1000으로 나눈 나머지를 구함
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(result[i][j] % MOD + " ");
            }
            System.out.println();
        }
    }
    
    // M^8 = (M^4)*(M^4) 같이 분할정복!!
    static int[][] pow(int[][] matrix, Long power) {
        int[][] result = new int[N][N];
        
        // 단위행렬 만듬
        for (int i = 0; i < N; i++) {
            result[i][i] = 1;
        }
        
        int[][] base = matrix;
        
        while (power > 0) {
            if (power % 2 == 1) {
                result = multiply(result, base);
            }
            base = multiply(base, base);
            power /= 2;
        }
        
        return result;
    }
    
    // 두 행렬을 곱하는 메서드
    static int[][] multiply(int[][] matrix1, int[][] matrix2) {
        int[][] product = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    product[i][j] += (matrix1[i][k] * matrix2[k][j]) % MOD;
                }
            }
        }
        return product;
    }
}
