import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int N = genres.length;
        
        Map<String, Integer> genreMap = new HashMap<>();
        Map<String, List<int[]>> songMap = new HashMap<>();
        for(int i=0;i<N;i++){
            String genre = genres[i];
            int play = plays[i];
            genreMap.put(genre,genreMap.getOrDefault(genre,0)+play);
            songMap.computeIfAbsent(genre, k -> new ArrayList<>()).add(new int[]{i, play});
        }
        
        List<String> list = new ArrayList<>(genreMap.keySet());
        list.sort((a, b) -> genreMap.get(b) - genreMap.get(a));
        
        List<Integer> result = new ArrayList<>();
        for (String genre : list) {
            List<int[]> songs = songMap.get(genre);
            songs.sort((a, b) -> b[1] == a[1] ? a[0] - b[0] : b[1] - a[1]);
            result.add(songs.get(0)[0]);
            if (songs.size() > 1) result.add(songs.get(1)[0]);
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}