import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int N = stoi(br.readLine());
        
        if(N%2==0) {
        	sb.append("CY");
        }
        else {
        	sb.append("SK");
        }
        System.out.print(sb);
    }
    
    public static int stoi(String str) {
    	return Integer.parseInt(str);
    }
}