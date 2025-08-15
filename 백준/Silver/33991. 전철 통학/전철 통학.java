import java.io.*;
import java.util.*;

public class Main {
	
	static int nextInt() throws IOException {
        int c;
        boolean neg = false;
        while ((c = System.in.read()) <= ' '); // 공백 무시
        if (c == '-') { // 음수 처리
            neg = true;
            c = System.in.read();
        }
        int value = c & 15;
        while ((c = System.in.read()) >= '0' && c <= '9') {
            value = value * 10 + (c & 15);
        }
        return neg ? -value : value;
    }
	
    static int boardingTime(int d, int t) {
        if (d % t == 0) {
            return d;
        }
        return (d / t + 1) * t;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int x1 = nextInt();
        int y1 = nextInt();
        int x2 = nextInt();
        int y2 = nextInt();
        int x3 = nextInt();
        int y3 = nextInt();

        int Q = nextInt();

        while (Q-- > 0) {
        	int x = nextInt();
        	int y = nextInt();
        	int t1 = nextInt();
        	int t2 = nextInt();
        	int t3 = nextInt();

        	int d1 = Math.abs(x - x1) + Math.abs(y - y1);
        	int d2 = Math.abs(x - x2) + Math.abs(y - y2);
        	int d3 = Math.abs(x - x3) + Math.abs(y - y3);

        	int result = Math.min(
                boardingTime(d1, t1),
                Math.min(boardingTime(d2, t2), boardingTime(d3, t3))
            );

            sb.append(result).append("\n");
        }

        System.out.print(sb);
    }
}
