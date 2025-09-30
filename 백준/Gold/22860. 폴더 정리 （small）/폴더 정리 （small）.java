import java.util.*;
import java.io.*;

public class Main {
    static class Folder {
        String name; // 폴더 이름
        List<Folder> childFolder = new ArrayList<>(); // 하위 폴더
        List<String> childFile = new ArrayList<>(); // 하위 파일

        Folder(String name) {
            this.name = name;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = stoi(st.nextToken());
        int M = stoi(st.nextToken());

        List<Folder> folders = new ArrayList<>();
        HashMap<String,Integer> index = new HashMap<>();
        folders.add(new Folder("main"));
        index.put("main",0);

        for(int i=0;i<N+M;i++){
            st = new StringTokenizer(br.readLine());
            String P = st.nextToken();
            String F = st.nextToken();
            int C = stoi(st.nextToken());

            if (C == 1) { // 폴더
                // 현재 폴더 가져오기 또는 새로 생성
                Folder cur;
                if (index.containsKey(F)) {
                    cur = folders.get(index.get(F));
                } else {
                    cur = new Folder(F);
                    folders.add(cur);
                    index.put(F, folders.size() - 1);
                }

                // 부모 폴더 가져오기 또는 새로 생성
                Folder parent;
                if (index.containsKey(P)) {
                    parent = folders.get(index.get(P));
                } else {
                    parent = new Folder(P);
                    folders.add(parent);
                    index.put(P, folders.size() - 1);
                }

                parent.childFolder.add(cur);

            } else { // 파일
                // 부모 폴더 가져오기 또는 새로 생성
                Folder parent;
                if (index.containsKey(P)) {
                    parent = folders.get(index.get(P));
                } else {
                    parent = new Folder(P);
                    folders.add(parent);
                    index.put(P, folders.size() - 1);
                }

                parent.childFile.add(F);
            }
        }
        int Q = Integer.parseInt(br.readLine());
        for (int i = 0; i < Q; i++) {
            String path = br.readLine();
            String[] pathParts = path.split("/");

            Folder cur = folders.get(0); // 루트 폴더 main

            for (int j = 1; j < pathParts.length; j++) {
                for (Folder f : cur.childFolder) {
                    if (f.name.equals(pathParts[j])) {
                        cur = f;
                        break;
                    }
                }
            }
            Set<String> uniqueFiles = new HashSet<>();
            int totalFiles = dfsCount(cur, uniqueFiles);

            sb.append(uniqueFiles.size()).append(" ").append(totalFiles).append("\n");
        }
        System.out.print(sb);
    }
    static int dfsCount(Folder folder, Set<String> set) {
        int cnt = folder.childFile.size();
        set.addAll(folder.childFile);
        for (Folder f : folder.childFolder) {
            cnt += dfsCount(f, set);
        }
        return cnt;
    }
    public static int stoi(String str) {
        return Integer.parseInt(str);
    }
}