import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int N = stoi(br.readLine());
        
        sb.append((N&1)==0?"CY":"SK");
        System.out.print(sb);
    }
    
    public static int stoi(String str) {
    	return Integer.parseInt(str);
    }
}