import java.util.*;
import java.io.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        String next = null;
        while( (next = br.readLine()) != null) {
        	int x = Integer.parseInt(next) * 10000000; 
        	int N = Integer.parseInt(br.readLine());
        	
        	int[] lego = new int[N];
        	for(int i=0;i<N;i++) {
        		lego[i] = Integer.parseInt(br.readLine());
        	}
        	Arrays.sort(lego);
        	
        	int left = 0;
        	int right = N-1;
        	boolean flag = false;
        	while(left<right) {
        		int sum = lego[left]+lego[right];
        		if(sum>x) {
        			right--;
        		}
        		else if (sum<x) {
        			left++;
        		}
        		else {
        			flag=true;
        			System.out.println("yes "+lego[left]+" "+lego[right]);
        			break;
        		}
        	}
        	if(!flag) {
        		System.out.println("danger");
        	}
        	next = null;
        }
    }
}
