import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        String N = br.readLine();
        
        int[] count = new int[10];
        
        for(int i=0;i<N.length();i++) {
        	int num = N.charAt(i)-'0';
        	if(num==6) {
        		count[9]++;
        	}
        	else {
        		count[num]++;
        	}
        }
        int max = Integer.MIN_VALUE;
        for(int i=0;i<9;i++) {
        	max = Math.max(count[i], max);
        }
        max = Math.max(count[9]/2+count[9]%2, max);
        System.out.println(max);
    }
}
