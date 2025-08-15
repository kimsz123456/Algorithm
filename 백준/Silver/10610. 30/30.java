import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        if (!str.contains("0")) {
            System.out.println(-1);
            return;
        }

        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            sum += str.charAt(i) - '0';
        }

        if (sum % 3 != 0) {
            System.out.println(-1);
            return;
        }

        char[] arr = str.toCharArray();
        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder(new String(arr));
        System.out.println(sb.reverse().toString());
    }
}
