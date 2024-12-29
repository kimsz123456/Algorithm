import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // BufferedWriter 추가
        int N = Integer.parseInt(br.readLine());

        BigInteger moves = hanoi(N);
        bw.write(moves + "\n"); // 옮긴 횟수 출력
        if(N<=20) {
        	move(N, 1, 3, bw);
        }

        bw.flush(); // 출력 버퍼 비우기
        bw.close();
    }

    // 원판 옮긴 횟수를 계산하는 메서드 (BigInteger 사용)
    public static BigInteger hanoi(int N) {
        return BigInteger.valueOf(2).pow(N).subtract(BigInteger.ONE); // 2^N - 1 계산
    }

    // N번 원판을 현재 위치에서 다음 위치로 옮기는 메서드
    public static void move(int N, int now, int next, BufferedWriter bw) throws IOException {
        if (N == 1) {
            bw.write(now + " " + next + "\n");
        } else {
            move(N - 1, now, 6 - now - next, bw); // N-1 원판을 다른 위치로 옮김
            bw.write(now + " " + next + "\n");   // 현재 위치 원판을 next 위치로 옮김
            move(N - 1, 6 - now - next, next, bw); // N-1 원판을 다시 옮겨옴
        }
    }
}
