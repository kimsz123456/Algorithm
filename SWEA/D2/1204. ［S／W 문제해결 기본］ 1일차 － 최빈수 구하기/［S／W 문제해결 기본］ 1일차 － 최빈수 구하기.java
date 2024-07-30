import java.util.Arrays;
import java.util.Scanner;
 
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트케이스의 개수 T
         
        for (int tc=0; tc<T; tc++) {
            int num = sc.nextInt(); // 테스트케이스의 번호
            int[] arr = new int[1000]; // 1000개의 값을 가진 배열
            for (int i=0;i<1000;i++) {
                arr[i]=sc.nextInt();
            }
            // 1000개의 배열에 값을 입력받음.
            Arrays.sort(arr);
            int max = arr[999];
            int[] countingSort = new int[max+1]; // 카운팅정렬을 담을 배열
            for(int i=0;i<1000;i++) {
                countingSort[arr[i]]++; //카운팅정렬
            }
            int mode = 0; // 최빈값
            int maxcnt = 0; // 카운트최대값
            for(int i=0;i<max+1;i++) {
                if(maxcnt<countingSort[i]) {
                    maxcnt = countingSort[i]; // 카운트의 최대값을 찾는다.
                    mode = i;   // 그때의 숫자를 mode(최빈값)에 저장
                }
                else if (maxcnt == countingSort[i]) { // cnt가 같을경우 더 높은 숫자를 최빈값으로 하기로 했으므로
                    mode = i;   // 같을때 최빈값 = i이다.
                }
            }
            System.out.println("#"+ num + " " + mode);
        }
    }
}