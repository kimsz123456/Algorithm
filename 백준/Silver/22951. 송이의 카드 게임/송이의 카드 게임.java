import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int N = nextInt();
        int K = nextInt();
        
        int[] card = new int[N*K];
        
        for(int i=0;i<N;i++) {
        	for(int j=0;j<K;j++) {
        		card[i*K+j]=nextInt();
        	}
        }
        int count = N*K-1;
        int idx = 0;
        while(count!=0) {
        	int cur = card[idx];
        	card[idx]=0;
        	while(cur>0) {
        		if(++idx>N*K-1) idx=0;
        		if(card[idx]!=0) cur--;
        	}
        	count--;
        }
        for(int i=0;i<N*K;i++) {
        	if(card[i]!=0) {
        		sb.append(i/K+1).append(" ").append(card[i]);
        	}
        }
        System.out.print(sb);
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
