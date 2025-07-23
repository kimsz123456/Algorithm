import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Long N = Long.parseLong(br.readLine());

        if(N%7==0 || N%7==2) System.out.print("CY");
        else System.out.println("SK");
    }
}