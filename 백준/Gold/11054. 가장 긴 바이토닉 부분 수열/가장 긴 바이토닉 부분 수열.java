import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] lis = new int[N]; // 앞에서부터 LIS
        int[] lds = new int[N]; // 뒤에서부터 LIS (실질적으로 LDS)

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // LIS 계산
        for (int i = 0; i < N; i++) {
            lis[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
        }

        // LDS 계산 (뒤에서부터 LIS 구하기)
        for (int i = N - 1; i >= 0; i--) {
            lds[i] = 1;
            for (int j = N - 1; j > i; j--) {
                if (arr[j] < arr[i]) {
                    lds[i] = Math.max(lds[i], lds[j] + 1);
                }
            }
        }

        // LIS + LDS - 1의 최대값 찾기
        int maxBitonic = 0;
        for (int i = 0; i < N; i++) {
            maxBitonic = Math.max(maxBitonic, lis[i] + lds[i] - 1);
        }

        System.out.println(maxBitonic);
    }
}