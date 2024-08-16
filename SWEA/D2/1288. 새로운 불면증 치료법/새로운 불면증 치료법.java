import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
        
        for (int tc = 1; tc <= T; tc++) {
            int num = Integer.parseInt(br.readLine());
            int first = num;
            boolean[] digits = new boolean[10];  // 0~9까지 숫자가 등장했는지 확인하는 배열
            int count = 0; // 등장한 숫자 개수
            
            while (true) {
                String str = String.valueOf(num);
                for (int i = 0; i < str.length(); i++) {
                    int digit = str.charAt(i) - '0';
                    if (!digits[digit]) {  // 처음 등장한 숫자라면
                        digits[digit] = true;
                        count++;
                    }
                }
                if (count == 10) break;  // 모든 숫자가 등장했다면 루프 종료
                
                num += first;
            }
            System.out.println("#" + tc + " " + num);
        }
    }
}