import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		
		int N = nextInt();
		
		for(int i=0;i<N;i++) {
			for(int j=N-i;j>0;j--) {
				sb.append("*");
			}
			sb.append("\n");
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
