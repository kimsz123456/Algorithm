import java.util.Scanner;

public class Solution {

	static int power;
	static int base;
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
    	int T = 10; // 테스트 케이스 갯수
    	
    	// 테스트케이스만큼 반복
    	for (int tc=1;tc<=T;tc++) {
    		int num = sc.nextInt();
    		base = sc.nextInt();
    		power = sc.nextInt();
    		System.out.println("#"+num+" "+exp(base,power));
    	}
    	sc.close();
    }
    
    public static int exp(int base,int power) {
    	if (power==0) {
    		return 1;
    	}
    	return base* exp(base,power-1);
    }
}
