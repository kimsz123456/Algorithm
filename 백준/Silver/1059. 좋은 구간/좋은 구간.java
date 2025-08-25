import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws IOException {

		int L = nextInt();

		int high = 1000;
		int low = 0;


		int[] arr = new int[L];
		for (int i = 0; i < L; i++) {
			arr[i] = nextInt();
		}

		int n = nextInt();

		for (int i = 0; i < L; i++) {
			int num = arr[i];

			if (num == n) {
				System.out.println(0);
				return;
			}
			if (num < n && low < num)
				low = num;
			if (num > n && high > num)
				high = num;
		}
		int result = 0;
		for (int i = (low + 1); i <= n; i++) {
			for (int j = n; j < high; j++) {
				result++;
			}
		}
		System.out.println((result - 1));
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
