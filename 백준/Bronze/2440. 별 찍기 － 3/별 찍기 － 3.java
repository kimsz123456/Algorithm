import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {

		int N = nextInt();
		for(int i=0;i<N;i++) {
			for(int j=N-i;j>0;j--) {
				System.out.print("*");
			}
			System.out.println();
		}
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
