import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = stoi(br.readLine());
        Set<Character> set = new HashSet<>();

        for(int i = 0; i < N; i++) {
            String line = br.readLine();
            String[] arr = line.split(" ");
            boolean selected = false;

            for(int j = 0; j < arr.length; j++) {
                char c = Character.toUpperCase(arr[j].charAt(0));
                if(!set.contains(c)) {
                    set.add(c);
                    arr[j] = "[" + arr[j].charAt(0) + "]" + arr[j].substring(1);
                    selected = true;
                    break;
                }
            }

            if(!selected) {
                outer:
                for(int j = 0; j < arr.length; j++) {
                    for(int k = 0; k < arr[j].length(); k++) {
                        char c = arr[j].charAt(k);
                        if(Character.isAlphabetic(c) && !set.contains(Character.toUpperCase(c))) {
                            set.add(Character.toUpperCase(c));
                            arr[j] = arr[j].substring(0, k) + "[" + c + "]" + arr[j].substring(k + 1);
                            selected = true;
                            break outer;
                        }
                    }
                }
            }

            for(int j = 0; j < arr.length; j++) {
                sb.append(arr[j]);
                if(j < arr.length - 1) sb.append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    public static int stoi(String str) {
        return Integer.parseInt(str);
    }
}
