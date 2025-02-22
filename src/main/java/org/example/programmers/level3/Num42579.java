package org.example.programmers.level3;

import java.util.*;
import java.util.stream.*;
public class Num42579 {
    class Solution {
        public List<Integer> solution(String[] genres, int[] plays) {
            List<Integer> answer = new ArrayList<>();
            Map<String, ArrayList<int[]>> genreMap = new HashMap<>();
            Map<String, Integer> playMap = new HashMap<>();
            for(int i=0; i< genres.length;i++){
                String genre = genres[i];
                int play = plays[i];
                if(!genreMap.containsKey(genre)){
                    genreMap.put(genre, new ArrayList<>());
                    playMap.put(genre, 0);
                }
                genreMap.get(genre).add(new int[]{i, play});
                playMap.put(genre, playMap.get(genre) + play);
            }

            Stream<Map.Entry<String, Integer>> sortedGenre= playMap.entrySet()
                    .stream().sorted((o1, o2) -> Integer.compare(o2.getValue(), o1.getValue()));

            //각 장르내에서 노래를 재생 횟수 순으로 정렬해 최대 2곡까지 선택
            sortedGenre.forEach(entry -> {
                Stream<int[]> sortedSong = genreMap.get(entry.getKey()).stream()
                        .sorted((o1, o2) -> Integer.compare(o2[1], o1[1]))
                        .limit(2);
                sortedSong.forEach(s -> answer.add(s[0]));
            });

            return answer;

        }

    }
}
