import java.util.*;
import java.io.*;

public class Solution {
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	
	static class Robot {
		int x,y,d;
		Robot(int x,int y, int d){
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			// 명령어
			String command = br.readLine();
			// 명령어 길이
			int l = command.length();
			
			int R = 0;
			int max = 0;
			
			Robot robot = new Robot(0,0,0);
			
			
			boolean flag = false;
			
			int num = 0;
			while(num<4*l) {
				char c = command.charAt(num%l);
				switch(c) {
				case 'S':
					robot.x = robot.x+dr[robot.d];
					robot.y = robot.y+dc[robot.d];
					
					R = robot.x*robot.x + robot.y*robot.y;
					// 최대값 갱신이 되면
					if(max<R) {
						max = R;
					}
					break;
				case 'L':
					robot.d = (robot.d+3)%4;
					break;
				case 'R':
					robot.d = (robot.d+1)%4;
					break;
				}
				num++;
			}
			if(robot.x!=0 || robot.y !=0) {
				sb.append("#").append(tc).append(" oo").append("\n");
			}
			else {
				sb.append("#").append(tc).append(" ").append(max).append("\n");
			}
		}
		System.out.println(sb);
	}
}