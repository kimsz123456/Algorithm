import java.util.*;
import java.io.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int n = Integer.parseInt(br.readLine());
    	
    	int[] score = new int[n];
    	for(int i=0;i<n;i++) {
    		score[i] = Integer.parseInt(br.readLine());
    	}
    	
    	int num = (int)Math.round((double)n*0.15);
    	int sum =0;
    	Arrays.sort(score);
    	for(int i=num;i<n-num;i++) {
    		sum +=score[i];
    	}
    	long result = Math.round( (double) sum / (n-2*num));
    	System.out.println(result);
    }
}
