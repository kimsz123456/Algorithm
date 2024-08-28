import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
	static int N,max,min;
	static int[] operator,num,equation;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        
        for (int tc = 1; tc <= T; tc++) {
        	min = Integer.MAX_VALUE;
        	max = Integer.MIN_VALUE;
        			
            N = Integer.parseInt(br.readLine());
            
            st = new StringTokenizer(br.readLine());
            operator = new int[4];
            for (int i = 0; i < 4; i++) {
                operator[i] = Integer.parseInt(st.nextToken());
            }
            
            st = new StringTokenizer(br.readLine());
            num = new int[N];
            for (int i = 0; i < N; i++) {
                num[i] = Integer.parseInt(st.nextToken());
            }
            equation = new int[N-1];
            
            perm(0);
            
            int result = max-min;
            System.out.println("#"+tc+" "+result);
        }
    }
	static void perm(int idx) {
		
		if(idx == N-1) {
			calcNum();
		}

		for(int i=0; i<4; i++) {
			if(operator[i] == 0) {
				continue;
			}
			operator[i]--;
			equation[idx] = i;
			perm(idx+1);
			operator[i]++;
		}
	}

	static void calcNum() {
		int number = num[0];
		for(int i=0; i<N-1; i++) {
			// +
			if(equation[i] == 0) {
				number+=num[i+1];
			}
			// -
			else if(equation[i] == 1) {
				number-=num[i+1];
			}
			// *
			else if(equation[i] == 2) {
				number*=num[i+1];
			}
			// /
			else if(equation[i] == 3) {
				number/=num[i+1];
			}
		}
		if(number > max)
			max = number;
		if (number < min)
			min = number;
		
	}
}

 