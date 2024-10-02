import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int set = 0; // 비트마스킹을 사용할 정수형 변수
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            int num;

            switch (str) {
                case "add":
                    num = Integer.parseInt(st.nextToken());
                    set |= (1 << num); // num 비트를 1로 설정
                    break;

                case "check":
                    num = Integer.parseInt(st.nextToken());
                    if ((set & (1 << num)) != 0) { // num 비트가 1인지 확인
                    	sb.append("1\n");
                    } else {
                        sb.append("0\n");
                    }
                    break;

                case "remove":
                    num = Integer.parseInt(st.nextToken());
                    set &= ~(1 << num); // num 비트를 0으로 설정
                    break;

                case "toggle":
                    num = Integer.parseInt(st.nextToken());
                    set ^= (1 << num); // num 비트를 토글
                    break;

                case "all":
                    set = (1 << 21) - 1; // 1부터 20까지의 모든 비트를 1로 설정
                    break;

                case "empty":
                    set = 0; // 모든 비트를 0으로 설정
                    break;
            }
        }
        System.out.println(sb);
    }
}
