import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
 
public class Solution {
    static int[] dr= {1,0};    //0:하
    static int[] dc= {0,1};    //1:우
    static String palindrome;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        for (int tc=1; tc<=10;tc++) {
            int l = Integer.parseInt(br.readLine()); // 회문의 길이            
            char[][] charArr = new char[8][8]; // 기존 문자열을 담을 배열
            int cnt = 0; // 회문의 갯수
            for (int i =0; i<charArr.length;i++) { //반복문을 통해 문자열을 담는다.
                String str = br.readLine(); // 문자열을 입력받음
                for (int j=0; j<charArr[0].length;j++) {
                    charArr[i][j] = str.charAt(j); // 그걸 배열에 넣는다.
                }
            }
             
            // (0,0)~(7,7)까지 모든 배열을 순회
            for (int i=0;i<(charArr.length);i++) {
                for(int j=0;j<(charArr[0].length);j++) {
                    //현재 i,j위치에서 우측델타와 아래델타 두번씩 회문인지 테스트
                    for(int d=0;d<2;d++) {
                        String temp = "";
                        for (int k=0; k<l;k++) { // l번 반복
                            if (i+k*dr[d]<8 && j+k*dc[d]<8) // 범위 넘어가지 않을때만
                            temp = temp + charArr[i+k*dr[d]][j+k*dc[d]];
                        }
                        if (temp.length() == l && palindromeTest(temp)) { // temp의 길이가 4일때만
                            cnt++;
                        }
                    }
                }
            }
            System.out.println("#" + tc+ " "+cnt);
        }    
    }
     
    // 회문테스트 메서드
    // 문자열을 받으면, 회문인지 아닌지를 boolean으로 반환
    public static boolean palindromeTest(String palindrome) {
        char[] charArr = new char[palindrome.length()]; // 기존 문자열을 담을 배열
         
        for (int i =0; i<palindrome.length();i++) { //반복문을 통해 문자열을 담는다.
            charArr[i] = palindrome.charAt(i);
        }
        char[] reverseArr = new char[charArr.length]; // 회문을 담을 배열 
          
        // 원본 배열을 정방향 순회하면서 새 배열의 뒤에서부터 써주기
        for(int i=0; i<charArr.length;i++) {
            reverseArr[(charArr.length-1)-i]=charArr[i];
        }
          
        boolean ans = (Arrays.equals(charArr,reverseArr));
         
        return ans;
    }
}