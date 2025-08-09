import java.util.*;
import java.io.*;

public class Main {
    static long M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int A = Integer.parseInt(br.readLine());
        String B = br.readLine();
        
        for(int i=2;i>=0;i--) {
        	sb.append(A*(B.charAt(i)-'0')).append("\n");
        }
        sb.append(A*Integer.parseInt(B));
        System.out.println(sb);
    }
}
