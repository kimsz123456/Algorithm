import java.util.Scanner;
 
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); 
        for (int i = 1; i <= T; i++) { // 테스트 케이스의 갯수만큼 반복
            int ans = -1; // 정답을 입력받을 변수
            for(int j=0; j<10;j++) {
                int num = sc.nextInt();
                if(ans < num) {
                    ans = num;
                }
            }
        System.out.println("#"+i+" "+ans);  
        }
    }
}