import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        
        int x = Integer.parseInt(br.readLine());
        
        int left =0;
        int right = arr.length-1;
        int sum = arr[left]+arr[right];
        int count =0;
        while(left<right) {
        	if(sum<x) {
        		sum -=arr[left++];
        		sum +=arr[left];
        	}
        	else if(sum>x) {
        		sum -=arr[right--];
        		sum +=arr[right];
        	}
        	else {
        		count++;
        		sum -=arr[left++];
        		sum +=arr[left];
        	}
        }
        System.out.println(count);
    }
}
