import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        
        int[] arr = new int[7];
        
        int count = 1;
        int max = 0;
        int dice = 0;
        for(int i=0;i<3;i++) {
        	int num = nextInt();
        	if(arr[num]!=0) {
        		dice = num;
        		count++;
        	}
        	max = Math.max(num, max);
        	arr[num]++;
        }
        
        int answer = 0;
        if(count==3) {
        	answer = 10000+1000*dice;
        }
        else if(count==2) {
        	answer = 1000+100*dice;
        }
        else {
        	answer = 100*max;
        }
        System.out.print(answer);
    }
	static int nextInt() throws IOException {
        int c;
        while (!Character.isDigit(c = System.in.read()));
        int value = c & 15;
        while (Character.isDigit(c = System.in.read())) {
            value = value * 10 + (c & 15);
        }
        return value;
    }
}
