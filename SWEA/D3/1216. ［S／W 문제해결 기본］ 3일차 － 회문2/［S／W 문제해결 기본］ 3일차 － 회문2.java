import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static char[][] charArr = new char[100][100]; // 기존 문자열을 담을 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int tc = 1; tc <= 10; tc++) {

            int num = Integer.parseInt(br.readLine()); // 테스트 케이스 번호
            int realMax = 0; // 최대값

            for (int i = 0; i < charArr.length; i++) { // 반복문을 통해 문자열을 담는다.
                String str = br.readLine(); // 문자열을 입력받음
                for (int j = 0; j < charArr[0].length; j++) {
                    charArr[i][j] = str.charAt(j); // 그걸 배열에 넣는다.
                }
            }

            // (0,0)~(99,99)까지 모든 배열을 순회
            for (int i = 0; i < charArr.length; i++) {
                for (int j = 0; j < charArr[0].length; j++) {
                    realMax = Math.max(realMax, palindromeTest(i, j)); // palindrometest를해서 realMax를 계속 갱신
                }
            }
            System.out.println("#" + num + " " + realMax);
        }
    }

    public static int palindromeTest(int x, int y) { // i,j값을 입력받아서 maxlength를 반환
        int maxlength = 1; // 최소 회문 길이는 1 (자기 자신)

        // 수직 방향 회문 검사
        maxlength = Math.max(maxlength, checkPalindrome(x, y, 1, 0)); // 짝수, 홀수 모두 검사
        // 수평 방향 회문 검사
        maxlength = Math.max(maxlength, checkPalindrome(x, y, 0, 1)); // 짝수, 홀수 모두 검사

        return maxlength;
    }

    public static int checkPalindrome(int x, int y, int dx, int dy) { // i,j와 dx,dy를 입력받아 maxlength를 반환
        int maxlength = 1;

        // 홀수 길이 회문 검사
        for (int i = 1; x - i  * dx >= 0 && y - i * dy >= 0 && x + i * dx < charArr.length && y + i * dy < charArr[0].length; i++) {
            if (charArr[x - i * dx][y - i * dy] == charArr[x + i * dx][y + i * dy]) { // 홀수길이는 가운데기준 양옆으로 1씩늘려가며 확인
                maxlength = Math.max(maxlength, 2 * i + 1); // 1은기본, 2i만큼 늘어남
            } else {
                break;
            }
        }

        // 짝수 길이 회문 검사
        for (int i = 0; x - i * dx >= 0 && y - i * dy >= 0 && x + (i + 1) * dx < charArr.length && y + (i + 1) * dy < charArr[0].length; i++) {
            if (charArr[x - i * dx][y - i * dy] == charArr[x + (i + 1) * dx][y + (i + 1) * dy]) { // 짝수길이는 가운데기준 한칸 이동한 값부터 같아야 함
                maxlength = Math.max(maxlength, 2 * (i + 1)); // i=0부터 2i씩 늘어남
            } else {
                break;
            }
        }

        return maxlength;
    }
}