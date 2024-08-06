import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		
		for(int i=1;i<=a;i++) {
			for(int p=a-i-1;p>=0;p--) {
				System.out.print(" ");
			}
			for(int q=1;q<=i;q++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}