import java.io.*;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String S = br.readLine();

        int count = 0;
        int result = 0;
        for (int i = 1; i < M - 1;) {
            if (S.charAt(i) == 'O' && S.charAt(i + 1) == 'I') {
                count++;
                if (count == N) {
                	if(S.charAt(i-(count*2-1)) == 'I')
                        result++;
                    count--;
                }
                i+=2;
            } else {
                count = 0;
                i++;
            }
        }
        System.out.println(result);
    }
}
