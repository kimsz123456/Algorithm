import java.util.*;
import java.io.*;

public class Main {
    static int count = 0; // 전역 변수로 관리

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        boolean found = insertion_sort(N, K, arr);
        if (!found) {
            System.out.println(-1);
        }
    }

    public static boolean insertion_sort(int N, int K, int[] arr) {
        for (int i = 1; i < N; i++) {
            int loc = i - 1;
            int newItem = arr[i];

            while (loc >= 0 && newItem < arr[loc]) {
                arr[loc + 1] = arr[loc];
                loc--;
                count++;
                if (count == K) {
                    printArray(arr);
                    return true;
                }
            }
            if (loc + 1 != i) {
                arr[loc + 1] = newItem;
                count++;
                if (count == K) {
                    printArray(arr);
                    return true;
                }
            }
        }
        return false;
    }

    public static void printArray(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int value : arr) {
            sb.append(value).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
