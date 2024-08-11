import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int a;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        for (int tc = 1; tc <= T; tc++) {

            int N = Integer.parseInt(br.readLine()); // 정수의 개수

            StringTokenizer st = new StringTokenizer(br.readLine()); // 정수
            
            // 정수들을 담은 배열
            int[] arr = new int[N];
            for(int i=0;i<N;i++) {
            	arr[i]=Integer.parseInt(st.nextToken());
            }
            
            // 정수들의 곱(A_i * A_j)을 담은 배열
            int[] multiple = new int[N*(N-1)/2];
            int k=0;
            for(int i=0;i<N-1;i++) {
            	for(int j=i+1;j<N;j++) {
            		multiple[k]=arr[i]*arr[j];
            		k++;
            	}
            }
            int max=-2;
            // multiple의 배열을 돌며 단조증가 판단, 그 최대값을 출력
            for(int i=0;i<multiple.length;i++) {
            	max =Math.max(ismonotoneinc(multiple[i]),max);
            }
            System.out.println("#"+tc+" "+max);
        }
    }
    
    static int ismonotoneinc(int a) {
    	// string으로 변환
    	String str = Integer.toString(a);	
    	
    	// 결과값
    	int result = a;
    	
    	// str의 0번인덱스부터 돌면서 단조증가이면 a값 반환
    	for (int i=0;i<str.length()-1;i++) {
    		if(str.charAt(i)-'0' <= str.charAt(i+1)-'0') {	// 단조증가일시
    			continue;
    		}
    		// 단조증가가아니면 -1반환
    		else {
    			result=-1;
    			break;
    		}
    	}
    	return result;
    }
}