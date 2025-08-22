import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		int N = nextInt();
		int L = nextInt();
		int H = nextInt();
		
		int[] score = new int[N];
		for(int i=0;i<N;i++) {
			score[i]= nextInt();
		}
		Arrays.sort(score);
		
		double sum = 0;
		for(int i=L;i<N-H;i++) {
			sum+=score[i];
		}
		System.out.print(sum/(N-H-L));
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
