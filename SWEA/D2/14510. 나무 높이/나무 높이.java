import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        for (int tc = 1; tc <= T; tc++) {

            int N = Integer.parseInt(br.readLine()); // 나무의 개수

            StringTokenizer st = new StringTokenizer(br.readLine()); // 나무의 높이

            int[] arr = new int[N]; // 나무의 높이 배열
            int max = 0;
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                max = Math.max(arr[i], max);
            }

            int odd = 0; // 홀수 개수
            int sum = 0; // 나무 높이 차이의 합계
            for (int i = 0; i < N; i++) {
                arr[i] = max - arr[i];
                if (arr[i] % 2 == 1) {
                    odd++;
                }
                sum += arr[i];
            }

            int result = 0;
            
            
            // 홀수 개수만큼 먼저 처리
            if(odd>0) {
            result += 2*odd-1;
            sum -= (3 * odd - 2);
            	if(sum>=2) {
            		result += 1;
            		sum-=2;
            	}
            }
            // 
            
            
            // 나머지 부분 처리
            if (sum > 0) {
                result += (sum / 3) * 2;
                int remainder = sum % 3;
                if (remainder == 1) {
                    result += 1;
                } else if (remainder == 2) {
                    result += 2;
                }
            }

            System.out.println("#" + tc + " " + result);
        }
    }
}