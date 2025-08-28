import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {

		int n = nextInt();
		int m = nextInt();
		
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = nextInt();
		}
		long sum = 0;
		for(int i=0;i<m;i++) {
			sum += arr[i];
		}
		long max = sum;
		for(int i=m;i<n;i++) {
			sum = sum - arr[i-m] + arr[i];
			max = Math.max(max, sum);
		}
		System.out.println(max);
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
