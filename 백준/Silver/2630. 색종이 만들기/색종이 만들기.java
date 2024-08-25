import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static boolean check;
	static int white = 0;
	static int blue = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[][] arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		cut(arr, 0, 0, N);
		System.out.println(white);
		System.out.println(blue);
	}

	public static void cut(int[][] arr, int x, int y, int size) {
	    if (check(arr, x, y, size)) {
	        if (arr[x][y] == 0) {
	            white++;
	        } else {
	            blue++;
	        }
	        return;
	    }

	    int newSize = size / 2;

	    cut(arr, x, y, newSize); // 1사분면
	    cut(arr, x, y + newSize, newSize); // 2사분면
	    cut(arr, x + newSize, y, newSize); // 3사분면
	    cut(arr, x + newSize, y + newSize, newSize); // 4사분면
	}

	public static boolean check(int[][] arr, int x, int y, int size) {
	    int color = arr[x][y];
	    for (int i = x; i < x + size; i++) {
	        for (int j = y; j < y + size; j++) {
	            if (arr[i][j] != color) {
	                return false;
	            }
	        }
	    }
	    return true;
	}
}