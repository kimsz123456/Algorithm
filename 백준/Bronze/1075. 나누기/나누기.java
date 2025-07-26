import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        int F = Integer.parseInt(br.readLine());
        
        int num = (N-N%100)%F;
        
        if(num==0) {
        	System.out.printf("%02d",num);
        }
        else {
        	System.out.printf("%02d",F-num);
        }
    }
}