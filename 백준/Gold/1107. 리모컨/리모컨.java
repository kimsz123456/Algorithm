import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static boolean[] broken;
    static int answer = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = stoi(br.readLine());
        int M = stoi(br.readLine());
        
        broken = new boolean[10];
        
        answer = Math.abs(N - 100);
        
        if (M == 10) {
            System.out.println(answer);
            return;
        }
        
        if (M > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                broken[stoi(st.nextToken())] = true;
            }
        }
        
        for (int digit = 1; digit <= 6; digit++) {
        	combination(digit,0,0);
        }
        
        System.out.println(answer);
    }
    
    static void combination(int digit, int cnt, int num) {
        if (cnt == digit) {
            int press = cnt + Math.abs(N - num);
            answer = Math.min(answer, press);
            return;
        }
        
        for (int i = 0; i <= 9; i++) {
            if (broken[i]) continue;
            if (cnt == 0 && i == 0 && digit > 1) continue;
            
            combination(digit, cnt + 1, num * 10 + i);
        }
    }

	public static int stoi(String str) {
		return Integer.parseInt(str);
	}
}