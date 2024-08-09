import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스
 
        for (int tc = 1; tc <= T; tc++) {
        	StringTokenizer st1 = new StringTokenizer(br.readLine());
        	
        	int N = Integer.parseInt(st1.nextToken());	// 신입사원의 수
        	int k_min = Integer.parseInt(st1.nextToken()); // 각 분반별 최소인원
        	int k_max = Integer.parseInt(st1.nextToken()); // 각 분반별 최대인원
        	
        	StringTokenizer st2 = new StringTokenizer(br.readLine());
        	
        	int[] arr = new int[N];
        	int[] count = new int[101];
        	int[] countsum = new int[101];
        	int[] countsumreverse = new int[101];
        	int min =100;
        	int max = 0;
        	for(int i=0;i<N;i++) {
        		int a = Integer.parseInt(st2.nextToken());
        		arr[i]=a;
        		min = Math.min(min, a);
        		max = Math.max(max, a);
        		count[a]++;
        	}
        	countsum[0]=count[0];
        	countsumreverse[100]=count[100];
        	for(int i=min;i<=max;i++) {
        		countsum[i]=countsum[i-1]+count[i];
        	}
        	for(int i=max;i>=min;i--) {
        		countsumreverse[i]=countsumreverse[i+1]+count[i];
        	}
        	int maximum = k_min;
        	int minimum = k_max;
        	for(int p=min;countsum[p]>=k_min && countsum[p]<=k_max;p++) {
        		int C = countsum[p];
        		for(int q=max;countsumreverse[q]>=k_min&&countsumreverse[q]<=k_max;q++) {
        			int A = countsumreverse[q];
        			int B = N-A-C;
        			if(B>=k_min&&B<=k_max) {
        				maximum = Math.max(Math.max(A,B),C);
        				minimum = Math.min(Math.min(A,B),C);
        				
        			}
        		}
        	}
        	if(maximum-minimum<0) {
        		System.out.println("#"+tc+" "+(-1));
        	}
        	else {
        		System.out.println("#"+tc+" "+(maximum-minimum));
        	}
        }
    }
}
