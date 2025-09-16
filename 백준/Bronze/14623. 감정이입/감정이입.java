import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String B1 = br.readLine();
        String B2 = br.readLine();

        long l1 = Long.parseLong(B1,2);
        long l2 = Long.parseLong(B2,2);

        String sum = Long.toBinaryString(l1 * l2);
        System.out.println(sum);

    }
}