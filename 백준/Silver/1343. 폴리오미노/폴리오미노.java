import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String board = br.readLine();
        board = board.replace("XXXX","AAAA");
        board = board.replace("XX","BB");
        if(board.contains("X")) System.out.print(-1);
        else System.out.print(board);
    }
}
