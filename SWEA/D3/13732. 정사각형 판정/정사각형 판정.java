import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int tc = 1; tc <= T; tc++) {
            
            int N = sc.nextInt(); // 격자판 크기
            char[][] square = new char[N][N]; // 격자판 배열
            String[] s = new String[N];
            for (int i = 0; i < N; i++) {
                s[i] = sc.next();
            }

            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    square[i][j] = s[i].charAt(j);
                    if (square[i][j] == '#')
                        cnt++;
                }
            }

//
//            int cnt = 0;
//            for (int i = 0; i < N; i++) {
//                for (int j = 0; j < N; j++) {
//                    if (square[i][j] == "#")
//                        cnt++;
//                }
//            }
//            System.out.println(cnt);
            boolean nemo = true;
            if(Math.sqrt(cnt)%1==0) {
            	out : for (int i = 0; i < N; i++) {
            		for (int j = 0; j < N; j++) {
            			
            			if (square[i][j] == '#') {
            				
            				for (int k = 0; k < Math.sqrt(cnt); k++) {
            					for (int l = 0; l < Math.sqrt(cnt); l++) {
            						if (i + k < N && j + l < N) {
            							if (square[i + k][j + l] != '#') {
            								nemo = false;
            								break out;
            							}
            						}
            						
            					}
            				}
            				break out;
            			}
            		}
            	}
            }
            else {
            	nemo=false;
            }
            if (nemo) {
                System.out.println("#" + tc + " " + "yes");
            } else
                System.out.println("#" + tc + " " + "no");

//            System.out.println(Arrays.deepToString(square));

        } // tc
    }// main

}