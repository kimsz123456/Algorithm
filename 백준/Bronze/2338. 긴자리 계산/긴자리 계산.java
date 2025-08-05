import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		BigInteger a = new BigInteger(sc.next());
        BigInteger b = new BigInteger(sc.next());
        
        BigInteger plus = a.add(b);
        BigInteger minus = a.subtract(b);
        BigInteger multiple = a.multiply(b);
        
        System.out.println(plus);
        System.out.println(minus);
        System.out.println(multiple);
    }
}
