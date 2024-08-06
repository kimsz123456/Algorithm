import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str;
		while ((str = br.readLine()) != null) {
            if (str.trim().isEmpty()) {
                break; // 공백 줄을 만나면 멈춤
            }
            System.out.println(str);
		}
	}
}
