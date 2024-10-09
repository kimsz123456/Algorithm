import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        
        // 수열
        int[] arr = new int[N];
        
        // LIS
        int[] lis = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        // 초기값
        lis[0]=arr[0];
        // LIS의 길이
        int length = 1;
        
        for(int i=1;i<N;i++) {
        	
        	// 수열의 다음값
        	int next = arr[i];
        	
        	// lis의 현재값보다 크면 이어붙이기
        	if(lis[length-1]<next) {
        		length++;
        		lis[length-1]=next;
        	}
        	
        	// lis의 현재값보다 작거나 같으면 이분탐색을 통해 바꿀 곳 찾기
        	else {
        		int left = 0;
        		int right = length;
        		while(left<right) {
        			int mid = (left+right)/2;
        			
        			if(lis[mid]<next) {
        				left = mid+1;
        			}
        			else {
        				right = mid;
        			}
        		}
        		lis[left]=next;
        	}
        }
        System.out.println(length);
    }
}